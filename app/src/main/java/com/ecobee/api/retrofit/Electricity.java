package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Electricity.shtml
 */
public class Electricity implements Serializable {

    private ElectricityDevice[] devices;

    public ElectricityDevice[] getDevices() {
        return devices;
    }

    public void setDevices(ElectricityDevice[] devices) {
        this.devices = devices;
    }
}
