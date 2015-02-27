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
        super(context, android.R.layout.simple_list_item_1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View element = super.getView(position, convertView, parent);
        CsvRevision thermostat = getItem(position);
        TextView text = (TextView) element.findViewById(android.R.id.text1);
        if (text!=null) {
            text.setText(thermostat.getThermostatName());
        }
        return element;
    }


}
