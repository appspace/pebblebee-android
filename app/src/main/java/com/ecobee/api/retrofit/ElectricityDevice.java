package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/ElectricityDevice.shtml
 */
public class ElectricityDevice implements Serializable {

    private String name;
    private ElectricityTier[] tiers;
    private String lastUpdate;
    private String[] cost;
    private String[] consumption;

    public ElectricityTier[] getTiers() {
        return tiers;
    }

    public void setTiers(ElectricityTier[] tiers) {
        this.tiers = tiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String[] getCost() {
        return cost;
    }

    public void setCost(String[] cost) {
        this.cost = cost;
    }

    public String[] getConsumption() {
        return consumption;
    }

    public void setConsumption(String[] consumption) {
        this.consumption = consumption;
    }
}
