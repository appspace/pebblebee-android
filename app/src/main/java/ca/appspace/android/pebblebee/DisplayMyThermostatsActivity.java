package ca.appspace.android.pebblebee;

import android.app.ListActivity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import com.ecobee.api.retrofit.CsvRevision;
import com.ecobee.api.retrofit.Thermostat;

import java.util.Collection;

/**
 * Created by eugene on 2015-02-24.
 */
public class DisplayMyThermostatsActivity extends ListActivity
		implements LoaderManager.LoaderCallbacks<Thermostat[]> {


	@Override
	public Loader<Thermostat[]> onCreateLoader(int id, Bundle args) {
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Thermostat[]> loader, Thermostat[] data) {

	}

	@Override
	public void onLoaderReset(Loader<Thermostat[]> loader) {

	}
}
