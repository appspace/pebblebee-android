package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/ElectricityTier.shtml
 */
public class ElectricityTier implements Serializable {

    private String name;
    private String consumption;
    private String cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
