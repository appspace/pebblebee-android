package ca.appspace.android.pebblebee;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.TextView;

import com.squareup.okhttp.internal.Platform;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LinkApplicationActivity extends ActionBarActivity {

    private final static String LINK_CODE_VALUE = "LINK_CODE_VALUE";
    private final static String LINK_CODE_TIMESTAMP = "LINK_CODE_TIMESTAMP";

    @InjectView(R.id.instructionsText)
    TextView _instructionsTxt;

    @InjectView(R.id.linkCodeTxt)
    TextView _linkCodeTxt;

    @InjectView(R.id.expirationChronometer)
    Chronometer _expirationChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_application);
        ButterKnife.inject(this);

        displayCode();
    }

    private void displayCode() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        long generatedAt = sharedPref.getLong(LINK_CODE_TIMESTAMP, 0);
        String generatedCode = sharedPref.getString(LINK_CODE_VALUE, null);
        if ((System.currentTimeMillis() - generatedAt) > EcobeeAPI.PIN_MAX_LIFE) {
            //If pin already expired, throw out the old code
            generatedCode = null;
            SharedPreferences.Editor prefsEditor = sharedPref.edit();
            prefsEditor.remove(LINK_CODE_VALUE);
            prefsEditor.remove(LINK_CODE_TIMESTAMP);
            prefsEditor.commit();
        }

        if (generatedCode==null) {
            _instructionsTxt.setText(getString(R.string.link_code_is_generated));
            _linkCodeTxt.setText("....");
            EcobeeAPI api = RemoteServiceFactory.createEcobeeApi(this);
            api.authorize("ecobeePin", EcobeeAPI.API_KEY, "smartWrite", new Callback<AuthorizeResponse>() {
                @Override
                public void success(AuthorizeResponse authorizeResponse, Response response) {
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LinkApplicationActivity.this);
                    SharedPreferences.Editor prefsEditor = sharedPref.edit();
                    prefsEditor.putString(LINK_CODE_VALUE, authorizeResponse.getEcobeePin());
                    prefsEditor.putLong(LINK_CODE_TIMESTAMP, System.currentTimeMillis());
                    prefsEditor.commit();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LinkApplicationActivity.this.displayCode();
                        }
                    });
                }

                @Override
                public void failure(RetrofitError error) {
                    _instructionsTxt.setText("Unable to connect to Ecobee server. Please check that " +
                            "network connection is avialable");
                }
            });
        } else {
            _instructionsTxt.setText(getString(R.string.link_app_description));
            _linkCodeTxt.setText(generatedCode);
            _expirationChronometer.start();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_link_application, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
