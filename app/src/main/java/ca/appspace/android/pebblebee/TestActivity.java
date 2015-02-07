package ca.appspace.android.pebblebee;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

    private final static UUID PEBBLE_APP_ID = UUID.fromString("1fd52557-d796-4489-bdc7-cdd100c95d16");

    @InjectView(R.id.btnStartWatchapp)
    Button _startWatchappBtn;

    @InjectView(R.id.btnSendData)
    Button _sendDataBtn;

    @InjectView(R.id.btnStopWatchapp)
    Button _stopWatchappBtn;

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
                PebbleKit.startAppOnPebble(getApplicationContext(), PEBBLE_APP_ID);
            }
        });

        _stopWatchappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PebbleKit.closeAppOnPebble(getApplicationContext(), PEBBLE_APP_ID);
            }
        });

        _sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PebbleDictionary data = new PebbleDictionary();
                data.addInt32(5, _counter.incrementAndGet());
                PebbleKit.sendDataToPebble(getApplicationContext(), PEBBLE_APP_ID, data);
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

        PebbleKit.registerReceivedAckHandler(getApplicationContext(), new PebbleKit.PebbleAckReceiver(PEBBLE_APP_ID) {

            @Override
            public void receiveAck(Context context, int transactionId) {
                Log.i(getLocalClassName(), "Received ack for transaction " + transactionId);
            }

        });

        PebbleKit.registerReceivedNackHandler(getApplicationContext(), new PebbleKit.PebbleNackReceiver(PEBBLE_APP_ID) {

            @Override
            public void receiveNack(Context context, int transactionId) {
                Log.i(getLocalClassName(), "Received nack for transaction " + transactionId);
            }

        });




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
