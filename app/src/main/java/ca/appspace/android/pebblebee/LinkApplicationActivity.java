package ca.appspace.android.pebblebee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import ca.appspace.android.pebblebee.ecobee.TokenResponse;

public class LinkApplicationActivity extends FragmentActivity {

    private final static String TAG = LinkApplicationActivity.class.getSimpleName();

    private final static String LINK_CODE_VALUE = "LINK_CODE_VALUE";
    private final static String LINK_CODE_TIMESTAMP = "LINK_CODE_TIMESTAMP";

    @InjectView(R.id.instructionsText)
    TextView _instructionsTxt;

    @InjectView(R.id.linkCodeTxt)
    TextView _linkCodeTxt;

    @InjectView(R.id.expiresInTxt)
    TextView _expiresInTxt;

    private CountDownTimer _tokenExpirationTimer;

    private final ApplicationLinkedEventReceiver _appLinkCodeReceiver = new ApplicationLinkedEventReceiver() {
        @Override
        public void onCodeReceived(AuthorizeResponse response) {
            displayCode(response.getEcobeePin(), System.currentTimeMillis());
        }

        @Override
        public void onFailure(String message) {
            handleError(message);
        }

        @Override
        public void onApplicationLinked(TokenResponse token) {
            handleApplicationLinked(token);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_application);
        ButterKnife.inject(this);

        LocalBroadcastManager.getInstance(this).registerReceiver(_appLinkCodeReceiver, ApplicationLinkedEventReceiver.getFilter());

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        long generatedAt = sharedPref.getLong(LINK_CODE_TIMESTAMP, 0);
        String generatedCode = sharedPref.getString(LINK_CODE_VALUE, null);
        Log.d(TAG, "Link code "+generatedCode+" generated at "+generatedAt+" loaded");
        if ( EcobeeAPI.PIN_MAX_LIFE <= (System.currentTimeMillis() - generatedAt) ) {
            Log.d(TAG, "Link code "+generatedCode+" is expired");
            //If pin already expired, throw out the old code
            generatedCode = null;
            SharedPreferences.Editor prefsEditor = sharedPref.edit();
            prefsEditor.remove(LINK_CODE_VALUE);
            prefsEditor.remove(LINK_CODE_TIMESTAMP);
            prefsEditor.commit();
        }

        if (generatedCode!=null) {
            displayCode(generatedCode, generatedAt);

            //Fake AuthResponse. Only generatedCode will be used
            AuthorizeResponse resp = new AuthorizeResponse();
            resp.setCode(generatedCode);
            resp.setExpiresIn(Long.valueOf(EcobeeAPI.PIN_MAX_LIFE - (System.currentTimeMillis() - generatedAt)).intValue());

            Intent intent = EcobeeAPIService.createPollIntent(this, resp, EcobeeAPI.API_KEY, EcobeeAPI.PIN_MAX_LIFE);
            startService(intent);
        } else {
            requestNewCode();
        }
    }

	private void handleApplicationLinked(TokenResponse token) {
		_instructionsTxt.setText(getString(R.string.application_linked));
		if (_tokenExpirationTimer!=null) {
			_tokenExpirationTimer.cancel();
		}
		_expiresInTxt.setText("");
		SharedPreferences.Editor prefsEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
		prefsEditor.remove(LINK_CODE_TIMESTAMP);
		prefsEditor.remove(LINK_CODE_VALUE);
		prefsEditor.putString(ApplicationPreferences.KEY_OAUTH_CODE, token.getAccessToken());
		prefsEditor.putString(ApplicationPreferences.KEY_OAUTH_REFRESH_CODE, token.getRefreshToken());
		prefsEditor.putLong(ApplicationPreferences.KEY_OAUTH_CODE_EXPIRES_IN,
				System.currentTimeMillis() + (token.getExpiresIn() * 60 * 1000));
		prefsEditor.commit();

		startActivity(new Intent(this, ThermostatsActivity.class));
	}

    private void requestNewCode() {
        Log.d(TAG, "Requesting new link code");
        //Start loading code
        Intent createNewCodeIntent = EcobeeAPIService.createNewLinkCodeReqIntent(this, EcobeeAPI.API_KEY);
        startService(createNewCodeIntent);

        //Let user know code is being loaded
        _instructionsTxt.setText(getString(R.string.link_code_is_generated));
        _linkCodeTxt.setText("....");

    }

    private void displayCode(String code, long generatedAt) {
        Log.d(TAG, "Displaying code "+code+" generated at "+generatedAt);
        //Display code to the user
        _instructionsTxt.setText(getString(R.string.link_app_description));
        _linkCodeTxt.setText(code);

        //Save code to preferences
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefsEditor = sharedPref.edit();
        prefsEditor.putString(LINK_CODE_VALUE, code);
        prefsEditor.putLong(LINK_CODE_TIMESTAMP, System.currentTimeMillis());
        prefsEditor.commit();

        long timeBeforeLinkExpires = EcobeeAPI.PIN_MAX_LIFE - (System.currentTimeMillis() - generatedAt);
        Log.d(TAG, "Code "+code+" expires in "+timeBeforeLinkExpires+" ms");
        if (_tokenExpirationTimer!=null) {  //If previous timer is still in place, cancel it
            _tokenExpirationTimer.cancel();
        }
        _tokenExpirationTimer = new CountDownTimer(timeBeforeLinkExpires, 1000) {

            public void onTick(long millisUntilFinished) {
                long secondsUntilFinished = millisUntilFinished / 1000;
                long minutesTillExpires = Math.abs(secondsUntilFinished / 60);
                secondsUntilFinished = secondsUntilFinished-(minutesTillExpires*60);
                if (minutesTillExpires>0) {
                    _expiresInTxt.setText(minutesTillExpires+":"+secondsUntilFinished);
                } else {
                    _expiresInTxt.setText(secondsUntilFinished+" seconds");
                }
            }

            public void onFinish() {
                _expiresInTxt.setText("done!"); //TODO: handle expired code
            }
        }.start();
    }

    private void handleError(String message) {
	    SharedPreferences.Editor prefsEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
	    prefsEditor.remove(LINK_CODE_TIMESTAMP);
	    prefsEditor.remove(LINK_CODE_VALUE);
		prefsEditor.commit();

        _instructionsTxt.setText(message);
        _expiresInTxt.setText("");
        _linkCodeTxt.setText(":-(");
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(_appLinkCodeReceiver);
        super.onDestroy();
    }
}
