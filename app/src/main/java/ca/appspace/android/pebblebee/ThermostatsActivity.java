package ca.appspace.android.pebblebee;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ca.appspace.android.pebblebee.ecobee.ApiRequest;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import ca.appspace.android.pebblebee.ecobee.Selection;
import ca.appspace.android.pebblebee.ecobee.SelectionType;
import ca.appspace.android.pebblebee.ecobee.Status;
import ca.appspace.android.pebblebee.ecobee.Thermostat;
import ca.appspace.android.pebblebee.ecobee.ThermostatData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ThermostatsActivity extends ActionBarActivity {

	private static final String TAG = ThermostatsActivity.class.getSimpleName();

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
		EcobeeAPI api = RemoteServiceFactory.createEcobeeApi(this);

		ApiRequest request = new ApiRequest();
		request.setSelection(new Selection());
		request.getSelection().setSelectionType(SelectionType.THERMOSTATS);
		request.getSelection().setSelectionMatch("");
		request.getSelection().setIncludeDevice(true);
		request.getSelection().setIncludeEvents(true);
		request.getSelection().setIncludeRuntime(true);

		api.getThermostats(request, new Callback<ThermostatData>() {
			@Override
			public void success(ThermostatData thermostatData, Response response) {
				Status status = thermostatData.getStatus();
				Thermostat[] thermostats = thermostatData.getThermostatList();
			}

			@Override
			public void failure(RetrofitError error) {

			}
		});
	}
}
