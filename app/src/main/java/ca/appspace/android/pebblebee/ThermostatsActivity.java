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
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ecobee.api.retrofit.ApiRequest;
import com.ecobee.api.retrofit.Selection;
import com.ecobee.api.retrofit.SelectionType;
import com.ecobee.api.retrofit.Status;
import com.ecobee.api.retrofit.ThermostatSummary;

import ca.appspace.android.pebblebee.ecobee.AuthApiWrapper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ThermostatsActivity extends ActionBarActivity {

	private static final String TAG = ThermostatsActivity.class.getSimpleName();

	private AuthApiWrapper _service;

	@InjectView(R.id.layout_thermostats)
	LinearLayout _thermostatsList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thermostats);

		ButterKnife.inject(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_thermostats, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings: {
				return true;
			}
			case R.id.action_reload_thermostats: {
				Log.d(TAG, "Number of elements in list: "+_thermostatsList.getChildCount());
				reloadThermostats();
				return true;
			}
			default : return super.onOptionsItemSelected(item);
		}
	}

	private void reloadThermostats() {
		if (_service==null) {
			Log.w(TAG, "Service is not bound - requests are not available");
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
			}

			@Override
			public void failure(RetrofitError error) {
				String reason = error.getResponse().getReason();
				Log.e(TAG, "Error loading thermostats: " + reason);

			}
		});
	}

	@Override
	public void onStart() {
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
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			_service = null;
		}
	};
}
