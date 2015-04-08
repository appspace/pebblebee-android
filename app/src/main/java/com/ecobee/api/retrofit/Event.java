package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Event.shtml
 */
public class Event implements Serializable {

    private String type;
    private String name;
    private Boolean running;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private Boolean isOccupied;
    private Boolean isCoolOff;
    private Boolean isHeatOff;
    private Integer coolHoldTemp;
    private Integer heatHoldTemp;
    private String fan;
    private String vent;
    private Integer ventilatorMinOnTime;
    private Boolean isOptional;
    private Boolean isTemperatureRelative;
    private Integer coolRelativeTemp;
    private Integer heatRelativeTemp;
    private Boolean isTemperatureAbsolute;
    private Integer dutyCyclePercentage;
    private Integer fanMinOnTime;
    private Boolean occupiedSensorActive;
    private Boolean unoccupiedSensorActive;
    private Integer drRampUpTemp;
    private Integer drRampUpTime;
    private String linkRef;
    private String holdClimateRef;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Boolean getIsCoolOff() {
        return isCoolOff;
    }

    public void setIsCoolOff(Boolean isCoolOff) {
        this.isCoolOff = isCoolOff;
    }

    public Boolean getIsHeatOff() {
        return isHeatOff;
    }

    public void setIsHeatOff(Boolean isHeatOff) {
        this.isHeatOff = isHeatOff;
    }

    public Integer getCoolHoldTemp() {
        return coolHoldTemp;
    }

    public void setCoolHoldTemp(Integer coolHoldTemp) {
        this.coolHoldTemp = coolHoldTemp;
    }

    public Integer getHeatHoldTemp() {
        return heatHoldTemp;
    }

    public void setHeatHoldTemp(Integer heatHoldTemp) {
        this.heatHoldTemp = heatHoldTemp;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public String getVent() {
        return vent;
    }

    public void setVent(String vent) {
        this.vent = vent;
    }

    public Integer getVentilatorMinOnTime() {
        return ventilatorMinOnTime;
    }

    public void setVentilatorMinOnTime(Integer ventilatorMinOnTime) {
        this.ventilatorMinOnTime = ventilatorMinOnTime;
    }

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public Boolean getIsTemperatureRelative() {
        return isTemperatureRelative;
    }

    public void setIsTemperatureRelative(Boolean isTemperatureRelative) {
        this.isTemperatureRelative = isTemperatureRelative;
    }

    public Integer getCoolRelativeTemp() {
        return coolRelativeTemp;
    }

    public void setCoolRelativeTemp(Integer coolRelativeTemp) {
        this.coolRelativeTemp = coolRelativeTemp;
    }

    public Integer getHeatRelativeTemp() {
        return heatRelativeTemp;
    }

    public void setHeatRelativeTemp(Integer heatRelativeTemp) {
        this.heatRelativeTemp = heatRelativeTemp;
    }

    public Boolean getIsTemperatureAbsolute() {
        return isTemperatureAbsolute;
    }

    public void setIsTemperatureAbsolute(Boolean isTemperatureAbsolute) {
        this.isTemperatureAbsolute = isTemperatureAbsolute;
    }

    public Integer getDutyCyclePercentage() {
        return dutyCyclePercentage;
    }

    public void setDutyCyclePercentage(Integer dutyCyclePercentage) {
        this.dutyCyclePercentage = dutyCyclePercentage;
    }

    public Integer getFanMinOnTime() {
        return fanMinOnTime;
    }

    public void setFanMinOnTime(Integer fanMinOnTime) {
        this.fanMinOnTime = fanMinOnTime;
    }

    public Boolean getOccupiedSensorActive() {
        return occupiedSensorActive;
    }

    public void setOccupiedSensorActive(Boolean occupiedSensorActive) {
        this.occupiedSensorActive = occupiedSensorActive;
    }

    public Boolean getUnoccupiedSensorActive() {
        return unoccupiedSensorActive;
    }

    public void setUnoccupiedSensorActive(Boolean unoccupiedSensorActive) {
        this.unoccupiedSensorActive = unoccupiedSensorActive;
    }

    public Integer getDrRampUpTemp() {
        return drRampUpTemp;
    }

    public void setDrRampUpTemp(Integer drRampUpTemp) {
        this.drRampUpTemp = drRampUpTemp;
    }

    public Integer getDrRampUpTime() {
        return drRampUpTime;
    }

    public void setDrRampUpTime(Integer drRampUpTime) {
        this.drRampUpTime = drRampUpTime;
    }

    public String getLinkRef() {
        return linkRef;
    }

    public void setLinkRef(String linkRef) {
        this.linkRef = linkRef;
    }

    public String getHoldClimateRef() {
        return holdClimateRef;
    }

    public void setHoldClimateRef(String holdClimateRef) {
        this.holdClimateRef = holdClimateRef;
    }
}
