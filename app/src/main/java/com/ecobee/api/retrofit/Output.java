package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Output.shtml
 */
public class Output implements Serializable {

    private String name;
    private Integer zone;
    private Integer outputId;
    private String type;
    private Boolean sendUpdate;
    private Boolean activeClosed;
    private Integer activationTime;
    private Integer deactivationTime;

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOutputId() {
        return outputId;
    }

    public void setOutputId(Integer outputId) {
        this.outputId = outputId;
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

    public Boolean getActiveClosed() {
        return activeClosed;
    }

    public void setActiveClosed(Boolean activeClosed) {
        this.activeClosed = activeClosed;
    }

    public Integer getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Integer activationTime) {
        this.activationTime = activationTime;
    }

    public Integer getDeactivationTime() {
        return deactivationTime;
    }

    public void setDeactivationTime(Integer deactivationTime) {
        this.deactivationTime = deactivationTime;
    }
}
