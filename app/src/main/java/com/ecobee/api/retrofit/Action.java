package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Action.shtml
 */
public class Action implements Serializable {

    private String type;
    private Boolean sendAlert;
    private Boolean sendUpdate;
    private Integer activationDelay;
    private Integer deactivationDelay;
    private Integer minActionDuration;
    private Integer heatAdjustTemp;
    private Integer coolAdjustTemp;
    private String activateRelay;
    private Boolean activateRelayOpen;

    public Boolean getSendAlert() {
        return sendAlert;
    }

    public void setSendAlert(Boolean sendAlert) {
        this.sendAlert = sendAlert;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSendUpdate() {
        return sendUpdate;
    }

    public void setSendUpdate(Boolean sendUpdate) {
        this.sendUpdate = sendUpdate;
    }

    public Integer getActivationDelay() {
        return activationDelay;
    }

    public void setActivationDelay(Integer activationDelay) {
        this.activationDelay = activationDelay;
    }

    public Integer getDeactivationDelay() {
        return deactivationDelay;
    }

    public void setDeactivationDelay(Integer deactivationDelay) {
        this.deactivationDelay = deactivationDelay;
    }

    public Integer getMinActionDuration() {
        return minActionDuration;
    }

    public void setMinActionDuration(Integer minActionDuration) {
        this.minActionDuration = minActionDuration;
    }

    public Integer getHeatAdjustTemp() {
        return heatAdjustTemp;
    }

    public void setHeatAdjustTemp(Integer heatAdjustTemp) {
        this.heatAdjustTemp = heatAdjustTemp;
    }

    public Integer getCoolAdjustTemp() {
        return coolAdjustTemp;
    }

    public void setCoolAdjustTemp(Integer coolAdjustTemp) {
        this.coolAdjustTemp = coolAdjustTemp;
    }

    public String getActivateRelay() {
        return activateRelay;
    }

    public void setActivateRelay(String activateRelay) {
        this.activateRelay = activateRelay;
    }

    public Boolean getActivateRelayOpen() {
        return activateRelayOpen;
    }

    public void setActivateRelayOpen(Boolean activateRelayOpen) {
        this.activateRelayOpen = activateRelayOpen;
    }
}
