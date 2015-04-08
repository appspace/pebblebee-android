package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Sensor.shtml
 */
public class Sensor implements Serializable {

    private String name;
    private String manufacturer;
    private String model;
    private Integer zone;
    private Integer sensorId;
    private String type;
    private String usage;
    private Integer numberOfBits;
    private Integer bconstant;
    private Integer thermistorSize;
    private Integer tempCorrection;
    private Integer gain;
    private Integer maxVoltage;
    private Integer multiplier;
    private State[] states;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public Integer getNumberOfBits() {
        return numberOfBits;
    }

    public void setNumberOfBits(Integer numberOfBits) {
        this.numberOfBits = numberOfBits;
    }

    public Integer getBconstant() {
        return bconstant;
    }

    public void setBconstant(Integer bconstant) {
        this.bconstant = bconstant;
    }

    public Integer getThermistorSize() {
        return thermistorSize;
    }

    public void setThermistorSize(Integer thermistorSize) {
        this.thermistorSize = thermistorSize;
    }

    public Integer getTempCorrection() {
        return tempCorrection;
    }

    public void setTempCorrection(Integer tempCorrection) {
        this.tempCorrection = tempCorrection;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }

    public Integer getMaxVoltage() {
        return maxVoltage;
    }

    public void setMaxVoltage(Integer maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    public State[] getStates() {
        return states;
    }

    public void setStates(State[] states) {
        this.states = states;
    }
}
