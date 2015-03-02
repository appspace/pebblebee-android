package ca.appspace.android.pebblebee;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ecobee.api.retrofit.*;
import com.ecobee.api.retrofit.Runtime;
import com.ecobee.api.retrofit.translator.RuntimeTranslator;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ca.appspace.android.pebblebee.ecobee.AuthApiWrapper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ThermostatDetailsActivity extends ActionBarActivity {

	private final static String TAG = ThermostatDetailsActivity.class.getSimpleName();
	private final static String THERMOSTAT_KEY = "extra.THERMOSTAT";
	private CsvRevision _thermostat;
	private AuthApiWrapper _service;
	private final static DecimalFormat NUMBER_FORMAT = new DecimalFormat("#0.0°C");


	@InjectView(R.id.currentTempVal)
	TextView _currentTempVal;

	public static Intent makeThermostatDetailsActivityIntent(Context context, CsvRevision thermostat) {
		Intent intent = new Intent(context, ThermostatDetailsActivity.class);
		intent.putExtra(THERMOSTAT_KEY, thermostat);
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thermostat_details);
		ButterKnife.inject(this);

		_thermostat = (CsvRevision) getIntent().getSerializableExtra(THERMOSTAT_KEY);

	}

	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = new Intent(this, AuthApiWrapper.class);
		bindService(intent, _serviceConnection, Context.BIND_AUTO_CREATE);
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
		request.getSelection().setSelectionType(SelectionType.THERMOSTATS);
		request.getSelection().setSelectionMatch(_thermostat.getThermostatId());
		request.getSelection().setIncludeRuntime(Boolean.TRUE);
		_service.getThermostats(request, new Callback<ThermostatData>() {
			@Override
			public void success(ThermostatData thermostatData, Response response) {
				Thermostat[] thermostats = thermostatData.getThermostatList();
				Runtime runtime = thermostats[0].getRuntime();
				BigDecimal tempInCelsius = RuntimeTranslator.getActualTemperature(runtime, TemperatureUnits.CELSIUS);
				String formattedValue = NUMBER_FORMAT.format(tempInCelsius);
				_currentTempVal.setText(formattedValue);

				PebbleDictionary data = new PebbleDictionary();
				data.addInt32(5, tempInCelsius.intValue());
				PebbleKit.sendDataToPebble(getApplicationContext(), ApplicationPreferences.PEBBLE_APP_ID, data);

			}

			@Override
			public void failure(RetrofitError error) {

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_thermostat_details, menu);
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
