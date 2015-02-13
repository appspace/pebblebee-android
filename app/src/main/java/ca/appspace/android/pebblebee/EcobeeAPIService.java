package ca.appspace.android.pebblebee;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;

import org.apache.http.HttpStatus;

import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EcobeeAPIService extends IntentService {

    private static final String ACTION_REQUEST_NEW_LINK_CODE = "pebblebee.action.ACTION_REQUEST_NEW_LINK_CODE";
    private static final String ACTION_BAZ = "ca.appspace.android.pebblebee.action.BAZ";

    private static final String API_KEY = "pebblebee.extra.API_KEY";
    private static final String EXTRA_PARAM2 = "ca.appspace.android.pebblebee.extra.PARAM2";

    public static Intent createNewLinkCodeReqIntent(Context context, String apiKey) {
        Intent intent = new Intent(context, EcobeeAPIService.class);
        intent.setAction(ACTION_REQUEST_NEW_LINK_CODE);
        intent.putExtra(API_KEY, apiKey);
        return intent;
    }

    public EcobeeAPIService() {
        super("EcobeeAPIService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_REQUEST_NEW_LINK_CODE.equals(action)) {
                final String appCode = intent.getStringExtra(API_KEY);
                requestNewCode(appCode);
            } else if (ACTION_BAZ.equals(action)) {
                //do something else
            }
        }
    }

    private void requestNewCode(final String developerCode) {
        EcobeeAPI api = RemoteServiceFactory.createEcobeeApi(this);
        api.authorize("ecobeePin", developerCode, "smartWrite", new Callback<AuthorizeResponse>() {
            @Override
            public void success(AuthorizeResponse authorizeResponse, Response response) {
                Intent intent = null;
                if (response.getStatus()== HttpStatus.SC_OK && authorizeResponse!=null) {
                    intent = ApplicationLinkedEventReceiver.createAuthResponseIntent(EcobeeAPIService.this, authorizeResponse);
                } else {
                    String reason = response.getReason();
                    intent = ApplicationLinkedEventReceiver.createErrorIntent(EcobeeAPIService.this, reason);
                }
                if (intent!=null) {
                    LocalBroadcastManager.getInstance(EcobeeAPIService.this).sendBroadcast(intent);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String reason = error.getResponse().getReason();
                Intent intent = ApplicationLinkedEventReceiver.createErrorIntent(EcobeeAPIService.this, reason);
                LocalBroadcastManager.getInstance(EcobeeAPIService.this).sendBroadcast(intent);
            }
        });
    }

}
