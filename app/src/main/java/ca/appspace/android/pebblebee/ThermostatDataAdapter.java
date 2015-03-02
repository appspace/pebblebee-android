package ca.appspace.android.pebblebee;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ecobee.api.retrofit.CsvRevision;
import com.ecobee.api.retrofit.Thermostat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 2015-02-27.
 */
public class ThermostatDataAdapter extends ArrayAdapter<CsvRevision> {

    public ThermostatDataAdapter(Context context) {
        super(context, R.layout.thermostat_list_entry, R.id.firstLine);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View element = super.getView(position, convertView, parent);
        CsvRevision thermostat = getItem(position);
        TextView firstLine = (TextView) element.findViewById(R.id.firstLine);
        if (firstLine!=null) {
            firstLine.setText(thermostat.getThermostatName());
        }
        TextView secondLine = (TextView) element.findViewById(R.id.secondLine);
        if (secondLine!=null) {
            secondLine.setText(thermostat.getThermostatId());
        }
        return element;
    }


}
