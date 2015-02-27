package com.ecobee.api.retrofit.translator;

import com.ecobee.api.retrofit.CsvRevision;
import com.ecobee.api.retrofit.Thermostat;
import com.ecobee.api.retrofit.ThermostatSummary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Eugene on 2015-02-27.
 */
public class ThermostatSummaryTranslator {

    public static Collection<CsvRevision> getThermostats(ThermostatSummary summary) {
        if (summary==null
                || summary.getRevisionList() == null
                || summary.getRevisionList().length==0
                || summary.getThermostatCount()==0) {
            return Collections.emptyList();
        }
        Collection<CsvRevision> result = new ArrayList<>(summary.getStatusList().length);
        for (String entry : summary.getRevisionList()) {
            String[] vals = entry.split(":");
            CsvRevision thermostat = new CsvRevision();
            if (vals.length>0) thermostat.setThermostatId(vals[0]);
            if (vals.length>1) thermostat.setThermostatName(vals[1]);
            if (vals.length>2) thermostat.setConnected(Boolean.valueOf(vals[2]));
            if (vals.length>3) thermostat.setThermostatRevision(vals[3]);
            if (vals.length>4) thermostat.setAlertsRevision(vals[4]);
            if (vals.length>5) thermostat.setRuntimeRevision(vals[5]);
            if (vals.length>6) thermostat.setIntervalRevision(vals[6]);
            result.add(thermostat);
        }
        return result;
    }
}
