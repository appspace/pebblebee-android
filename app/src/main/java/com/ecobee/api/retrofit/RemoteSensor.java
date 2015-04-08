package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/RemoteSensor.shtml
 */
public class RemoteSensor implements Serializable {

    private String id;
    private String name;
    private String type;
    private String code;
    private Boolean inUse;
    private RemoteSensorCapability[] capability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public RemoteSensorCapability[] getCapability() {
        return capability;
    }

    public void setCapability(RemoteSensorCapability[] capability) {
        this.capability = capability;
    }
}
