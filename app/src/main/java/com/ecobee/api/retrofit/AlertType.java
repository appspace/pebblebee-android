package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-04-08.
 */
public enum AlertType {

    ALERT("alert"),
    DEMAND_RESPONSE("demandResponse"),
    EMERGENCY("emergency"),
    MESSAGE("message"),
    PRICING("pricing");

    private final String jsonValue;

    AlertType(String jsonValue) {
        this.jsonValue = jsonValue;
    }
}
