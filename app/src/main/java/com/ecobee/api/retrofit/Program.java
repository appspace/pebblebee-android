package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Program.shtml
 */
public class Program implements Serializable {

    private String[][] schedule;
    private Climate[] climates;
    private String currentClimateRef;

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Climate[] getClimates() {
        return climates;
    }

    public void setClimates(Climate[] climates) {
        this.climates = climates;
    }

    public String getCurrentClimateRef() {
        return currentClimateRef;
    }

    public void setCurrentClimateRef(String currentClimateRef) {
        this.currentClimateRef = currentClimateRef;
    }
}
