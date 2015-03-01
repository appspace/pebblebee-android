package ca.appspace.android.pebblebee;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ecobee.api.retrofit.ApiRequest;
import com.ecobee.api.retrofit.CsvRevision;
import com.ecobee.api.retrofit.Selection;
import com.ecobee.api.retrofit.SelectionType;
import com.ecobee.api.retrofit.Status;
import com.ecobee.api.retrofit.Thermostat;
import com.ecobee.api.retrofit.ThermostatSummary;
import com.ecobee.api.retrofit.translator.ThermostatSummaryTranslator;

import ca.appspace.android.pebblebee.ecobee.AuthApiWrapper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by eugene on 2015-02-24.
 */
public class DisplayMyThermostatsActivity extends ListActivity {

    private final static String TAG = DisplayMyThermostatsActivity.class.getSimpleName();

    private ArrayAdapter<CsvRevision> _dataAdapter;

    private AuthApiWrapper _service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_my_thermostats);

        _dataAdapter = new ThermostatDataAdapter(this);
        setListAdapter(_dataAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, AuthApiWrapper.class);
        bindService(intent, _serviceConnection, Context.BIND_AUTO_CREATE);
        reloadData();
    }

    @Override
    public void onStop() {
        super.onStop();
        unbindService(_serviceConnection);
    }

    private ServiceConnection _serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            _service = ((AuthApiWrapper.LocalBinder)service).getService();
            reloadData();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            _service = null;
        }
    };

    private void reloadData() {
        if (_service==null) {
            Log.w(TAG, "Service is not bound - requests are not available");
            return;
        }
        ApiRequest request = new ApiRequest();
        request.setSelection(new Selection());
        request.getSelection().setSelectionType(SelectionType.REGISTERED);
        request.getSelection().setSelectionMatch("");

        _service.getThermostatSummary(request, new Callback<ThermostatSummary>() {
            @Override
            public void success(ThermostatSummary thermostatData, Response response) {
                Status status = thermostatData.getStatus();
                Integer count = thermostatData.getThermostatCount();
                String[] revisionList = thermostatData.getRevisionList();
                String[] statusList = thermostatData.getStatusList();

                _dataAdapter.addAll(ThermostatSummaryTranslator.getThermostats(thermostatData));
            }

            @Override
            public void failure(RetrofitError error) {
                String reason = error.getResponse().getReason();
                Log.e(TAG, "Error loading thermostats: " + reason);

            }
        });

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(DisplayMyThermostatsActivity.this,
                "Item at position "+position+" clicked",
                Toast.LENGTH_SHORT).show();
    }
}
