package ca.appspace.android.pebblebee;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TestActivity extends ActionBarActivity {

	private final static String TAG = TestActivity.class.getSimpleName();


    @InjectView(R.id.btnStartWatchapp)
    Button _startWatchappBtn;

    @InjectView(R.id.btnSendData)
    Button _sendDataBtn;

    @InjectView(R.id.btnStopWatchapp)
    Button _stopWatchappBtn;

    @InjectView(R.id.btnLinkApp)
    Button _linkAppBtn;

    @InjectView(R.id.txtDebugInfo)
    EditText _debugInfo;

    private AtomicInteger _counter = new AtomicInteger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.inject(this);

        _startWatchappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PebbleKit.startAppOnPebble(getApplicationContext(), ApplicationPreferences.PEBBLE_APP_ID);
            }
        });

        _stopWatchappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PebbleKit.closeAppOnPebble(getApplicationContext(), ApplicationPreferences.PEBBLE_APP_ID);
            }
        });

        _sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PebbleDictionary data = new PebbleDictionary();
                data.addInt32(5, _counter.incrementAndGet());
                PebbleKit.sendDataToPebble(getApplicationContext(), ApplicationPreferences.PEBBLE_APP_ID, data);
            }
        });

        PebbleKit.registerPebbleConnectedReceiver(getApplicationContext(), new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(getLocalClassName(), "Pebble connected!");
            }

        });

        PebbleKit.registerPebbleDisconnectedReceiver(getApplicationContext(), new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(getLocalClassName(), "Pebble disconnected!");
            }

        });

        PebbleKit.registerReceivedAckHandler(getApplicationContext(),
		        new PebbleKit.PebbleAckReceiver(ApplicationPreferences.PEBBLE_APP_ID) {
            @Override
            public void receiveAck(Context context, int transactionId) {
                Log.i(getLocalClassName(), "Received ack for transaction " + transactionId);
            }

        });

        PebbleKit.registerReceivedNackHandler(getApplicationContext(),
		        new PebbleKit.PebbleNackReceiver(ApplicationPreferences.PEBBLE_APP_ID) {
            @Override
            public void receiveNack(Context context, int transactionId) {
                Log.i(getLocalClassName(), "Received nack for transaction " + transactionId);
            }

        });

        PebbleKit.registerReceivedDataHandler(this,
		        new PebbleKit.PebbleDataReceiver(ApplicationPreferences.PEBBLE_APP_ID) {
            @Override
            public void receiveData(final Context context, final int transactionId, final PebbleDictionary data) {
                Long keyCode = data.getInteger(5);
                Log.i(getLocalClassName(), "Received value=" + keyCode + " for key: 5");
                switch (keyCode.intValue()) {
                    case 2 : {
                        _counter.set(0);
                        break;
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        _debugInfo.setText("Received Button Down command from Pebble");
                    }
                });
                PebbleKit.sendAckToPebble(getApplicationContext(), transactionId);
            }

        });

	    String oauthCode = PreferenceManager.getDefaultSharedPreferences(this).getString(ApplicationPreferences.KEY_OAUTH_REFRESH_CODE, null);
	    Log.d(TAG, "OAuth refresh code loaded from preferences: "+oauthCode);
		if (oauthCode!=null && !oauthCode.trim().isEmpty()) {
			Log.d(TAG, "OAuth code available, continuing to ThermostatActivity.");
			_linkAppBtn.setVisibility(View.INVISIBLE);
			_linkAppBtn.setEnabled(false);
			startActivity(new Intent(this, ThermostatsActivity.class));
		} else {
			Log.d(TAG, "OAuth code is not available, application is not linked.");
			_linkAppBtn.setVisibility(View.VISIBLE);
			_linkAppBtn.setEnabled(true);
			_linkAppBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent startLinkActivity = new Intent(TestActivity.this, LinkApplicationActivity.class);
					startActivity(startLinkActivity);
				}
			});
		}

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
