package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Version.shtml
 */
public class Version implements Serializable {

    private String thermostatFirmwareVersion;

    public String getThermostatFirmwareVersion() {
        return thermostatFirmwareVersion;
    }

    public void setThermostatFirmwareVersion(String thermostatFirmwareVersion) {
        this.thermostatFirmwareVersion = thermostatFirmwareVersion;
    }
}
