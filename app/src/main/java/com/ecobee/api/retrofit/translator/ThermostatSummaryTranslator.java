package com.ecobee.api.retrofit.translator;

import com.ecobee.api.retrofit.CsvRevision;
import com.ecobee.api.retrofit.CsvStatus;
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
        Collection<CsvRevision> result = new ArrayList<>(summary.getRevisionList().length);
        for (String entry : summary.getRevisionList()) {
            String[] vals = entry.split(":");
            CsvRevision thermostat = new CsvRevision();
            if (vals.length>0) thermostat.setThermostatId(vals[0].trim());
            if (vals.length>1) thermostat.setThermostatName(vals[1].trim());
            if (vals.length>2) thermostat.setConnected(Boolean.valueOf(vals[2].trim()));
            if (vals.length>3) thermostat.setThermostatRevision(vals[3].trim());
            if (vals.length>4) thermostat.setAlertsRevision(vals[4].trim());
            if (vals.length>5) thermostat.setRuntimeRevision(vals[5].trim());
            if (vals.length>6) thermostat.setIntervalRevision(vals[6].trim());
            result.add(thermostat);
        }
        return result;
    }

    public static Collection<CsvStatus> getStatuses(ThermostatSummary summary) {
        if (summary==null
                || summary.getStatusList() == null
                || summary.getStatusList().length==0
                || summary.getThermostatCount()==0) {
            return Collections.emptyList();
        }
        Collection<CsvStatus> result = new ArrayList<>(summary.getStatusList().length);
        for (String entry : summary.getStatusList()) {
            String vals[]  = entry.split(":");
            CsvStatus status = new CsvStatus();
            if (vals.length>0) status.setThermostatId(vals[0].trim());
            if (vals.length>1) status.setStatus(vals[1].split(","));
            result.add(status);
        }
        return result;
    }
}
