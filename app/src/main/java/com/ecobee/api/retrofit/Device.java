package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Device.shtml
 */
public class Device implements Serializable {

    private Integer deviceId;
    private String name;
    private Sensor[] sensors;
    private Output[] outputs;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sensor[] getSensors() {
        return sensors;
    }

    public void setSensors(Sensor[] sensors) {
        this.sensors = sensors;
    }

    public Output[] getOutputs() {
        return outputs;
    }

    public void setOutputs(Output[] outputs) {
        this.outputs = outputs;
    }
}
