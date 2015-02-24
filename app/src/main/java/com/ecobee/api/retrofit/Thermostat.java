package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-19.
 */
public class Thermostat implements Serializable {

    private String identifier;

    private String name;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
