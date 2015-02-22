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

public class LinkApplicationService extends IntentService {

    private static final String TAG = LinkApplicationService.class.getSimpleName();

    private static final int POLL_TIME_BETWEEN_REQUESTS = 30000;

    private static final String ACTION_REQUEST_NEW_LINK_CODE = "pebblebee.action.ACTION_REQUEST_NEW_LINK_CODE";
    private static final String ACTION_LINK_POLL = "pebblebee.action.ACTION_LINK_POLL";

    private static final String EXTRA_API_KEY = "pebblebee.extra.EXTRA_API_KEY";
    private static final String EXTRA_AUTH_RESPONSE = "pebblebee.extra.EXTRA_AUTH_RESPONSE";
    private static final String EXTRA_MAX_POLL_TIME = "pebblebee.extra.EXTRA_MAX_POLL_TIME";

    private static final String GRANT_TYPE = "ecobeePin";

    private EcobeeAPI _api;

    public static Intent createNewLinkCodeReqIntent(Context context, String apiKey) {
        Intent intent = new Intent(context, LinkApplicationService.class);
        intent.setAction(ACTION_REQUEST_NEW_LINK_CODE);
        intent.putExtra(EXTRA_API_KEY, apiKey);
        return intent;
    }

    /**
     * Creates an intent for polling ecobee service with authCode obtained from
     * new link code request. Polling will continue every __ seconds but no longer
     * then for pollForMs timeout.
     * @param context
     * @param authResponse
     * @param apiKey
     * @param pollForMs maximum time until polling stops. Zero or negative values will
     *                  result in only one poll request. Maximum value should not exceed
     *                  token timeout (10 minutes).
     * @return
     */
    public static Intent createPollIntent(Context context, AuthorizeResponse authResponse,
                                          String apiKey, long pollForMs) {
        Intent intent = new Intent(context, LinkApplicationService.class);
        intent.setAction(ACTION_LINK_POLL);
        intent.putExtra(EXTRA_AUTH_RESPONSE, authResponse);
        intent.putExtra(EXTRA_API_KEY, apiKey);
        if (pollForMs>0 && pollForMs<EcobeeAPI.PIN_MAX_LIFE) {
            intent.putExtra(EXTRA_MAX_POLL_TIME, pollForMs);
        }
        return intent;
    }

    public LinkApplicationService() {
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
            switch (action) {
                case ACTION_LINK_POLL : {
                    final AuthorizeResponse authResponse = (AuthorizeResponse) intent.getSerializableExtra(EXTRA_AUTH_RESPONSE);
                    final String apiKey = intent.getStringExtra(EXTRA_API_KEY);
                    long maxTime = intent.getLongExtra(EXTRA_MAX_POLL_TIME, 0);
                    if (maxTime<1 || maxTime>EcobeeAPI.PIN_MAX_LIFE) {
                        maxTime = 0;
                    }
                    startLinkPoll(authResponse, apiKey, maxTime);
                    break;
                }
                case ACTION_REQUEST_NEW_LINK_CODE : {
                    final String appCode = intent.getStringExtra(EXTRA_API_KEY);
                    requestNewCode(appCode);
                    break;
                }
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
                    intent = ApplicationLinkedEventReceiver.createAuthResponseIntent(LinkApplicationService.this, authorizeResponse);
                    //Received successful response, so let's poll ecobee for information if user has entered the code
                    startLinkPoll(authorizeResponse, developerCode, EcobeeAPI.PIN_MAX_LIFE);
                } else {
                    String reason = response.getReason();
                    intent = ApplicationLinkedEventReceiver.createErrorIntent(LinkApplicationService.this, reason);
                }
                if (intent!=null) {
                    LocalBroadcastManager.getInstance(LinkApplicationService.this).sendBroadcast(intent);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String reason = error.getResponse().getReason();
                Intent intent = ApplicationLinkedEventReceiver.createErrorIntent(LinkApplicationService.this, reason);
                LocalBroadcastManager.getInstance(LinkApplicationService.this).sendBroadcast(intent);
            }
        });
    }

    private void startLinkPoll(final AuthorizeResponse authorizeResponse, final String developerCode, final long maxTime) {
        if (maxTime>0) {
            new CountDownTimer(maxTime, POLL_TIME_BETWEEN_REQUESTS) {

	            private boolean firstRun = true;

                public void onTick(long millisUntilFinished) {
	                if (firstRun) {
		                firstRun = false;
		                return;
	                }
                    runSinglePollRequest(authorizeResponse, developerCode);
                }

                public void onFinish() {

                }
            }.start();
        } else {
            runSinglePollRequest(authorizeResponse, developerCode);
        }
    }

    private void runSinglePollRequest(final AuthorizeResponse authorizeResponse, final String developerCode) {
        _api.token(GRANT_TYPE, authorizeResponse.getCode(), developerCode, new Callback<TokenResponse>() {
            @Override
            public void success(TokenResponse tokenResponse, Response response) {
                Intent intent = null;
                if (response.getStatus() == HttpStatus.SC_OK && tokenResponse != null) {
                    intent = ApplicationLinkedEventReceiver.createAppLinkedIntent(LinkApplicationService.this, tokenResponse);
                } else {
	                intent = ApplicationLinkedEventReceiver.createErrorIntent(LinkApplicationService.this, response.getReason());
                    Log.d(TAG, "Error on checking if app is linked: " + response.getReason());
                }
                if (intent != null) {
                    LocalBroadcastManager.getInstance(LinkApplicationService.this).sendBroadcast(intent);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error on checking if app is linked: " + error.getResponse().getReason());
	            /**
	             * Following comes here, but in error.getResponse().getBody()
	             *
	             *     {
	             "error": "authorization_pending",
	             "error_descripton": "Waiting for user to authorize application.",
	             "error_uri": "http://tools.ietf.org/html/draft-ietf-oauth-v2-31#section-5.2"
	             }
	             */

	            //Intent intent = ApplicationLinkedEventReceiver.createErrorIntent(EcobeeAPIService.this, error.getResponse().getReason());
	            //LocalBroadcastManager.getInstance(EcobeeAPIService.this).sendBroadcast(intent);
            }
        });
    }

}
