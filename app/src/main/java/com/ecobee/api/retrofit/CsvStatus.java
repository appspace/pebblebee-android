package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 */
public class CsvStatus implements Serializable {
    private String thermostatId;
    private String[] status;

    public String getThermostatId() {
        return thermostatId;
    }

    public void setThermostatId(String thermostatId) {
        this.thermostatId = thermostatId;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
}
