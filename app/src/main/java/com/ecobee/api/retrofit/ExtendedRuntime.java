package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/ExtendedRuntime.shtml
 */
public class ExtendedRuntime implements Serializable {

    private String lastReadingTimestamp;
    private String runtimeDate;
    private Integer runtimeInterval;
    private Integer[] actualTemperature;
    private Integer[] actualHumidity;
    private Integer[] desiredHeat;
    private Integer[] desiredCool;
    private Integer[] desiredHumidity;
    private Integer[] desiredDehumidity;
    private Integer[] dmOffset;
    private String[] hvacMode;
    private Integer[] heatPump1;
    private Integer[] heatPump2;
    private Integer[] auxHeat1;
    private Integer[] auxHeat2;
    private Integer[] auxHeat3;
    private Integer[] cool1;
    private Integer[] cool2;
    private Integer[] fan;
    private Integer[] humidifier;
    private Integer[] dehumidifier;
    private Integer[] economizer;
    private Integer[] ventilator;
    private Integer currentElectricityBill;
    private Integer projectedElectricityBill;

    public String getRuntimeDate() {
        return runtimeDate;
    }

    public void setRuntimeDate(String runtimeDate) {
        this.runtimeDate = runtimeDate;
    }

    public String getLastReadingTimestamp() {
        return lastReadingTimestamp;
    }

    public void setLastReadingTimestamp(String lastReadingTimestamp) {
        this.lastReadingTimestamp = lastReadingTimestamp;
    }

    public Integer getRuntimeInterval() {
        return runtimeInterval;
    }

    public void setRuntimeInterval(Integer runtimeInterval) {
        this.runtimeInterval = runtimeInterval;
    }

    public Integer[] getActualTemperature() {
        return actualTemperature;
    }

    public void setActualTemperature(Integer[] actualTemperature) {
        this.actualTemperature = actualTemperature;
    }

    public Integer[] getActualHumidity() {
        return actualHumidity;
    }

    public void setActualHumidity(Integer[] actualHumidity) {
        this.actualHumidity = actualHumidity;
    }

    public Integer[] getDesiredHeat() {
        return desiredHeat;
    }

    public void setDesiredHeat(Integer[] desiredHeat) {
        this.desiredHeat = desiredHeat;
    }

    public Integer[] getDesiredCool() {
        return desiredCool;
    }

    public void setDesiredCool(Integer[] desiredCool) {
        this.desiredCool = desiredCool;
    }

    public Integer[] getDesiredHumidity() {
        return desiredHumidity;
    }

    public void setDesiredHumidity(Integer[] desiredHumidity) {
        this.desiredHumidity = desiredHumidity;
    }

    public Integer[] getDesiredDehumidity() {
        return desiredDehumidity;
    }

    public void setDesiredDehumidity(Integer[] desiredDehumidity) {
        this.desiredDehumidity = desiredDehumidity;
    }

    public Integer[] getDmOffset() {
        return dmOffset;
    }

    public void setDmOffset(Integer[] dmOffset) {
        this.dmOffset = dmOffset;
    }

    public String[] getHvacMode() {
        return hvacMode;
    }

    public void setHvacMode(String[] hvacMode) {
        this.hvacMode = hvacMode;
    }

    public Integer[] getHeatPump1() {
        return heatPump1;
    }

    public void setHeatPump1(Integer[] heatPump1) {
        this.heatPump1 = heatPump1;
    }

    public Integer[] getHeatPump2() {
        return heatPump2;
    }

    public void setHeatPump2(Integer[] heatPump2) {
        this.heatPump2 = heatPump2;
    }

    public Integer[] getAuxHeat1() {
        return auxHeat1;
    }

    public void setAuxHeat1(Integer[] auxHeat1) {
        this.auxHeat1 = auxHeat1;
    }

    public Integer[] getAuxHeat2() {
        return auxHeat2;
    }

    public void setAuxHeat2(Integer[] auxHeat2) {
        this.auxHeat2 = auxHeat2;
    }

    public Integer[] getAuxHeat3() {
        return auxHeat3;
    }

    public void setAuxHeat3(Integer[] auxHeat3) {
        this.auxHeat3 = auxHeat3;
    }

    public Integer[] getCool1() {
        return cool1;
    }

    public void setCool1(Integer[] cool1) {
        this.cool1 = cool1;
    }

    public Integer[] getCool2() {
        return cool2;
    }

    public void setCool2(Integer[] cool2) {
        this.cool2 = cool2;
    }

    public Integer[] getFan() {
        return fan;
    }

    public void setFan(Integer[] fan) {
        this.fan = fan;
    }

    public Integer[] getHumidifier() {
        return humidifier;
    }

    public void setHumidifier(Integer[] humidifier) {
        this.humidifier = humidifier;
    }

    public Integer[] getDehumidifier() {
        return dehumidifier;
    }

    public void setDehumidifier(Integer[] dehumidifier) {
        this.dehumidifier = dehumidifier;
    }

    public Integer[] getEconomizer() {
        return economizer;
    }

    public void setEconomizer(Integer[] economizer) {
        this.economizer = economizer;
    }

    public Integer[] getVentilator() {
        return ventilator;
    }

    public void setVentilator(Integer[] ventilator) {
        this.ventilator = ventilator;
    }

    public Integer getCurrentElectricityBill() {
        return currentElectricityBill;
    }

    public void setCurrentElectricityBill(Integer currentElectricityBill) {
        this.currentElectricityBill = currentElectricityBill;
    }

    public Integer getProjectedElectricityBill() {
        return projectedElectricityBill;
    }

    public void setProjectedElectricityBill(Integer projectedElectricityBill) {
        this.projectedElectricityBill = projectedElectricityBill;
    }
}
