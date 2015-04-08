package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/State.shtml
 */
public class State {

    private Integer maxValue;
    private Integer minValue;
    private String type;
    private Action[] actions;

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Action[] getActions() {
        return actions;
    }

    public void setActions(Action[] actions) {
        this.actions = actions;
    }
}
