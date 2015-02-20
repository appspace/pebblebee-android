package ca.appspace.android.pebblebee;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.apache.http.HttpStatus;

import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import ca.appspace.android.pebblebee.ecobee.TokenResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EcobeeAPIService extends IntentService {
    private static final String TAG = EcobeeAPIService.class.getSimpleName();
    private static final String ACTION_REQUEST_NEW_LINK_CODE = "pebblebee.action.ACTION_REQUEST_NEW_LINK_CODE";
    private static final String ACTION_BAZ = "ca.appspace.android.pebblebee.action.BAZ";

    private static final String API_KEY = "pebblebee.extra.API_KEY";

    private static final String GRANT_TYPE = "ecobeePin";

    private EcobeeAPI _api;

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
    public void onCreate() {
        super.onCreate();
        _api = RemoteServiceFactory.createEcobeeApi(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_REQUEST_NEW_LINK_CODE.equals(action)) {
                final String appCode = intent.getStringExtra(API_KEY);
                requestNewCode(appCode);
            }
        }
    }

    private void requestNewCode(final String developerCode) {
        EcobeeAPI api = RemoteServiceFactory.createEcobeeApi(this);
        api.authorize(GRANT_TYPE, developerCode, "smartWrite", new Callback<AuthorizeResponse>() {
            @Override
            public void success(AuthorizeResponse authorizeResponse, Response response) {
                Intent intent = null;
                if (response.getStatus()== HttpStatus.SC_OK && authorizeResponse!=null) {
                    intent = ApplicationLinkedEventReceiver.createAuthResponseIntent(EcobeeAPIService.this, authorizeResponse);
                    //Received successful response, so let's poll ecobee for information if user has entered the code
                    startLinkPoll(authorizeResponse, developerCode);
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

    private void startLinkPoll(final AuthorizeResponse authorizeResponse, final String developerCode) {
        new CountDownTimer(EcobeeAPI.PIN_MAX_LIFE, 1000) {
            public void onTick(long millisUntilFinished) {
                _api.token(GRANT_TYPE, authorizeResponse.getCode(), developerCode, new Callback<TokenResponse>() {
                    @Override
                    public void success(TokenResponse tokenResponse, Response response) {
                        Intent intent = null;
                        if (response.getStatus()== HttpStatus.SC_OK && tokenResponse!=null) {
                            intent = ApplicationLinkedEventReceiver.createAppLinkedIntent(EcobeeAPIService.this, tokenResponse);
                        } else {
                            Log.d(TAG, "Error on checking if app is linked: "+response.getReason());
                        }
                        if (intent!=null) {
                            LocalBroadcastManager.getInstance(EcobeeAPIService.this).sendBroadcast(intent);
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, "Error on checking if app is linked: "+error.getResponse().getReason());
                    }
                });
            }

            public void onFinish() {

            }
        }.start();
    }

}
