package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Settings.shtml
 */
public class Settings implements Serializable {
    private String hvacMode;
    private String lastServiceDate;
    private Boolean serviceRemindMe;
    private Integer monthsBetweenService;
    private String remindMeDate;
    private String vent;
    private Integer ventilatorMinOnTime;
    private Boolean serviceRemindTechnician;
    private String eiLocation;
    private Integer coldTempAlert;
    private Boolean coldTempAlertEnabled;
    private Integer hotTempAlert;
    private Boolean hotTempAlertEnabled;
    private Integer coolStages;
    private Integer heatStages;
    private Integer maxSetBack;
    private Integer maxSetForward;
    private Integer quickSaveSetBack;
    private Integer quickSaveSetForward;
    private Boolean hasHeatPump;
    private Boolean hasForcedAir;
    private Boolean hasBoiler;
    private Boolean hasHumidifier;
    private Boolean hasErv;
    private Boolean hasHrv;
    private Boolean condensationAvoid;
    private Boolean useCelsius;
    private Boolean useTimeFormat12;
    private String locale;
    private String humidity;
    private String humidifierMode;
    private Integer backlightOnIntensity;
    private Integer backlightSleepIntensity;
    private Integer backlightOffTime;
    private Integer soundTickVolume;
    private Integer soundAlertVolume;
    private Integer compressorProtectionMinTime;
    private Integer compressorProtectionMinTemp;
    private Integer stage1HeatingDifferentialTemp;
    private Integer stage1CoolingDifferentialTemp;
    private Integer stage1HeatingDissipationTime;
    private Integer stage1CoolingDissipationTime;
    private Boolean heatPumpReversalOnCool;
    private Boolean fanControlRequired;
    private Integer fanMinOnTime;
    private Integer heatCoolMinDelta;
    private Integer tempCorrection;
    private String holdAction;
    private Boolean heatPumpGroundWater;
    private Boolean hasElectric;
    private Boolean hasDehumidifier;
    private String dehumidifierMode;
    private Integer dehumidifierLevel;
    private Boolean dehumidifyWithAC;
    private Integer dehumidifyOvercoolOffset;
    private Boolean autoHeatCoolFeatureEnabled;
    private Boolean wifiOfflineAlert;
    private Integer heatMinTemp;
    private Integer heatMaxTemp;
    private Integer coolMinTemp;
    private Integer coolMaxTemp;
    private Integer heatRangeHigh;
    private Integer heatRangeLow;
    private Integer coolRangeHigh;
    private Integer coolRangeLow;
    private String userAccessCode;
    private Integer userAccessSetting;
    private Integer auxRuntimeAlert;
    private Integer auxOutdoorTempAlert;
    private Integer auxMaxOutdoorTemp;
    private Boolean auxRuntimeAlertNotify;
    private Boolean auxOutdoorTempAlertNotify;
    private Boolean auxRuntimeAlertNotifyTechnician;
    private Boolean auxOutdoorTempAlertNotifyTechnician;
    private Boolean disablePreHeating;
    private Boolean disablePreCooling;
    private Boolean installerCodeRequired;
    private String drAccept;
    private Boolean isRentalProperty;
    private Boolean useZoneController;
    private Integer randomStartDelayCool;
    private Integer randomStartDelayHeat;
    private Integer humidityHighAlert;
    private Integer humidityLowAlert;
    private Boolean disableHeatPumpAlerts;
    private Boolean disableAlertsOnIdt;
    private Boolean humidityAlertNotify;
    private Boolean humidityAlertNotifyTechnician;
    private Boolean tempAlertNotify;
    private Boolean tempAlertNotifyTechnician;
    private Integer monthlyElectricityBillLimit;
    private Boolean enableElectricityBillAlert;
    private Boolean enableProjectedElectricityBillAlert;
    private Integer electricityBillingDayOfMonth;
    private Integer electricityBillCycleMonths;
    private Integer electricityBillStartMonth;
    private Integer ventilatorMinOnTimeHome;
    private Integer ventilatorMinOnTimeAway;
    private Boolean backlightOffDuringSleep;
    private Boolean autoAway;
    private Boolean smartCirculation;
    private Boolean followMeComfort;
    private String ventilatorType;
    private Boolean isVentilatorTimerOn;
    private String ventilatorOffDateTime;
    private Boolean hasUVFilter;
    private Boolean coolingLockout;
    private Boolean ventilatorFreeCooling;
    private Boolean dehumidifyWhenHeating;
    private Boolean ventilatorDehumidify;
    private String groupRef;
    private String groupName;
    private Integer groupSetting;

    public String getHvacMode() {
        return hvacMode;
    }

    public void setHvacMode(String hvacMode) {
        this.hvacMode = hvacMode;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Boolean getServiceRemindMe() {
        return serviceRemindMe;
    }

    public void setServiceRemindMe(Boolean serviceRemindMe) {
        this.serviceRemindMe = serviceRemindMe;
    }

    public Integer getMonthsBetweenService() {
        return monthsBetweenService;
    }

    public void setMonthsBetweenService(Integer monthsBetweenService) {
        this.monthsBetweenService = monthsBetweenService;
    }

    public String getRemindMeDate() {
        return remindMeDate;
    }

    public void setRemindMeDate(String remindMeDate) {
        this.remindMeDate = remindMeDate;
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

    public Boolean getServiceRemindTechnician() {
        return serviceRemindTechnician;
    }

    public void setServiceRemindTechnician(Boolean serviceRemindTechnician) {
        this.serviceRemindTechnician = serviceRemindTechnician;
    }

    public String getEiLocation() {
        return eiLocation;
    }

    public void setEiLocation(String eiLocation) {
        this.eiLocation = eiLocation;
    }

    public Integer getColdTempAlert() {
        return coldTempAlert;
    }

    public void setColdTempAlert(Integer coldTempAlert) {
        this.coldTempAlert = coldTempAlert;
    }

    public Boolean getColdTempAlertEnabled() {
        return coldTempAlertEnabled;
    }

    public void setColdTempAlertEnabled(Boolean coldTempAlertEnabled) {
        this.coldTempAlertEnabled = coldTempAlertEnabled;
    }

    public Integer getHotTempAlert() {
        return hotTempAlert;
    }

    public void setHotTempAlert(Integer hotTempAlert) {
        this.hotTempAlert = hotTempAlert;
    }

    public Boolean getHotTempAlertEnabled() {
        return hotTempAlertEnabled;
    }

    public void setHotTempAlertEnabled(Boolean hotTempAlertEnabled) {
        this.hotTempAlertEnabled = hotTempAlertEnabled;
    }

    public Integer getCoolStages() {
        return coolStages;
    }

    public void setCoolStages(Integer coolStages) {
        this.coolStages = coolStages;
    }

    public Integer getHeatStages() {
        return heatStages;
    }

    public void setHeatStages(Integer heatStages) {
        this.heatStages = heatStages;
    }

    public Integer getMaxSetBack() {
        return maxSetBack;
    }

    public void setMaxSetBack(Integer maxSetBack) {
        this.maxSetBack = maxSetBack;
    }

    public Integer getMaxSetForward() {
        return maxSetForward;
    }

    public void setMaxSetForward(Integer maxSetForward) {
        this.maxSetForward = maxSetForward;
    }

    public Integer getQuickSaveSetBack() {
        return quickSaveSetBack;
    }

    public void setQuickSaveSetBack(Integer quickSaveSetBack) {
        this.quickSaveSetBack = quickSaveSetBack;
    }

    public Integer getQuickSaveSetForward() {
        return quickSaveSetForward;
    }

    public void setQuickSaveSetForward(Integer quickSaveSetForward) {
        this.quickSaveSetForward = quickSaveSetForward;
    }

    public Boolean getHasHeatPump() {
        return hasHeatPump;
    }

    public void setHasHeatPump(Boolean hasHeatPump) {
        this.hasHeatPump = hasHeatPump;
    }

    public Boolean getHasForcedAir() {
        return hasForcedAir;
    }

    public void setHasForcedAir(Boolean hasForcedAir) {
        this.hasForcedAir = hasForcedAir;
    }

    public Boolean getHasBoiler() {
        return hasBoiler;
    }

    public void setHasBoiler(Boolean hasBoiler) {
        this.hasBoiler = hasBoiler;
    }

    public Boolean getHasHumidifier() {
        return hasHumidifier;
    }

    public void setHasHumidifier(Boolean hasHumidifier) {
        this.hasHumidifier = hasHumidifier;
    }

    public Boolean getHasErv() {
        return hasErv;
    }

    public void setHasErv(Boolean hasErv) {
        this.hasErv = hasErv;
    }

    public Boolean getHasHrv() {
        return hasHrv;
    }

    public void setHasHrv(Boolean hasHrv) {
        this.hasHrv = hasHrv;
    }

    public Boolean getCondensationAvoid() {
        return condensationAvoid;
    }

    public void setCondensationAvoid(Boolean condensationAvoid) {
        this.condensationAvoid = condensationAvoid;
    }

    public Boolean getUseCelsius() {
        return useCelsius;
    }

    public void setUseCelsius(Boolean useCelsius) {
        this.useCelsius = useCelsius;
    }

    public Boolean getUseTimeFormat12() {
        return useTimeFormat12;
    }

    public void setUseTimeFormat12(Boolean useTimeFormat12) {
        this.useTimeFormat12 = useTimeFormat12;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getHumidifierMode() {
        return humidifierMode;
    }

    public void setHumidifierMode(String humidifierMode) {
        this.humidifierMode = humidifierMode;
    }

    public Integer getBacklightOnIntensity() {
        return backlightOnIntensity;
    }

    public void setBacklightOnIntensity(Integer backlightOnIntensity) {
        this.backlightOnIntensity = backlightOnIntensity;
    }

    public Integer getBacklightSleepIntensity() {
        return backlightSleepIntensity;
    }

    public void setBacklightSleepIntensity(Integer backlightSleepIntensity) {
        this.backlightSleepIntensity = backlightSleepIntensity;
    }

    public Integer getBacklightOffTime() {
        return backlightOffTime;
    }

    public void setBacklightOffTime(Integer backlightOffTime) {
        this.backlightOffTime = backlightOffTime;
    }

    public Integer getSoundTickVolume() {
        return soundTickVolume;
    }

    public void setSoundTickVolume(Integer soundTickVolume) {
        this.soundTickVolume = soundTickVolume;
    }

    public Integer getSoundAlertVolume() {
        return soundAlertVolume;
    }

    public void setSoundAlertVolume(Integer soundAlertVolume) {
        this.soundAlertVolume = soundAlertVolume;
    }

    public Integer getCompressorProtectionMinTime() {
        return compressorProtectionMinTime;
    }

    public void setCompressorProtectionMinTime(Integer compressorProtectionMinTime) {
        this.compressorProtectionMinTime = compressorProtectionMinTime;
    }

    public Integer getCompressorProtectionMinTemp() {
        return compressorProtectionMinTemp;
    }

    public void setCompressorProtectionMinTemp(Integer compressorProtectionMinTemp) {
        this.compressorProtectionMinTemp = compressorProtectionMinTemp;
    }

    public Integer getStage1HeatingDifferentialTemp() {
        return stage1HeatingDifferentialTemp;
    }

    public void setStage1HeatingDifferentialTemp(Integer stage1HeatingDifferentialTemp) {
        this.stage1HeatingDifferentialTemp = stage1HeatingDifferentialTemp;
    }

    public Integer getStage1CoolingDifferentialTemp() {
        return stage1CoolingDifferentialTemp;
    }

    public void setStage1CoolingDifferentialTemp(Integer stage1CoolingDifferentialTemp) {
        this.stage1CoolingDifferentialTemp = stage1CoolingDifferentialTemp;
    }

    public Integer getStage1HeatingDissipationTime() {
        return stage1HeatingDissipationTime;
    }

    public void setStage1HeatingDissipationTime(Integer stage1HeatingDissipationTime) {
        this.stage1HeatingDissipationTime = stage1HeatingDissipationTime;
    }

    public Integer getStage1CoolingDissipationTime() {
        return stage1CoolingDissipationTime;
    }

    public void setStage1CoolingDissipationTime(Integer stage1CoolingDissipationTime) {
        this.stage1CoolingDissipationTime = stage1CoolingDissipationTime;
    }

    public Boolean getHeatPumpReversalOnCool() {
        return heatPumpReversalOnCool;
    }

    public void setHeatPumpReversalOnCool(Boolean heatPumpReversalOnCool) {
        this.heatPumpReversalOnCool = heatPumpReversalOnCool;
    }

    public Boolean getFanControlRequired() {
        return fanControlRequired;
    }

    public void setFanControlRequired(Boolean fanControlRequired) {
        this.fanControlRequired = fanControlRequired;
    }

    public Integer getFanMinOnTime() {
        return fanMinOnTime;
    }

    public void setFanMinOnTime(Integer fanMinOnTime) {
        this.fanMinOnTime = fanMinOnTime;
    }

    public Integer getHeatCoolMinDelta() {
        return heatCoolMinDelta;
    }

    public void setHeatCoolMinDelta(Integer heatCoolMinDelta) {
        this.heatCoolMinDelta = heatCoolMinDelta;
    }

    public Integer getTempCorrection() {
        return tempCorrection;
    }

    public void setTempCorrection(Integer tempCorrection) {
        this.tempCorrection = tempCorrection;
    }

    public String getHoldAction() {
        return holdAction;
    }

    public void setHoldAction(String holdAction) {
        this.holdAction = holdAction;
    }

    public Boolean getHeatPumpGroundWater() {
        return heatPumpGroundWater;
    }

    public void setHeatPumpGroundWater(Boolean heatPumpGroundWater) {
        this.heatPumpGroundWater = heatPumpGroundWater;
    }

    public Boolean getHasElectric() {
        return hasElectric;
    }

    public void setHasElectric(Boolean hasElectric) {
        this.hasElectric = hasElectric;
    }

    public Boolean getHasDehumidifier() {
        return hasDehumidifier;
    }

    public void setHasDehumidifier(Boolean hasDehumidifier) {
        this.hasDehumidifier = hasDehumidifier;
    }

    public String getDehumidifierMode() {
        return dehumidifierMode;
    }

    public void setDehumidifierMode(String dehumidifierMode) {
        this.dehumidifierMode = dehumidifierMode;
    }

    public Integer getDehumidifierLevel() {
        return dehumidifierLevel;
    }

    public void setDehumidifierLevel(Integer dehumidifierLevel) {
        this.dehumidifierLevel = dehumidifierLevel;
    }

    public Boolean getDehumidifyWithAC() {
        return dehumidifyWithAC;
    }

    public void setDehumidifyWithAC(Boolean dehumidifyWithAC) {
        this.dehumidifyWithAC = dehumidifyWithAC;
    }

    public Integer getDehumidifyOvercoolOffset() {
        return dehumidifyOvercoolOffset;
    }

    public void setDehumidifyOvercoolOffset(Integer dehumidifyOvercoolOffset) {
        this.dehumidifyOvercoolOffset = dehumidifyOvercoolOffset;
    }

    public Boolean getAutoHeatCoolFeatureEnabled() {
        return autoHeatCoolFeatureEnabled;
    }

    public void setAutoHeatCoolFeatureEnabled(Boolean autoHeatCoolFeatureEnabled) {
        this.autoHeatCoolFeatureEnabled = autoHeatCoolFeatureEnabled;
    }

    public Boolean getWifiOfflineAlert() {
        return wifiOfflineAlert;
    }

    public void setWifiOfflineAlert(Boolean wifiOfflineAlert) {
        this.wifiOfflineAlert = wifiOfflineAlert;
    }

    public Integer getHeatMinTemp() {
        return heatMinTemp;
    }

    public void setHeatMinTemp(Integer heatMinTemp) {
        this.heatMinTemp = heatMinTemp;
    }

    public Integer getHeatMaxTemp() {
        return heatMaxTemp;
    }

    public void setHeatMaxTemp(Integer heatMaxTemp) {
        this.heatMaxTemp = heatMaxTemp;
    }

    public Integer getCoolMinTemp() {
        return coolMinTemp;
    }

    public void setCoolMinTemp(Integer coolMinTemp) {
        this.coolMinTemp = coolMinTemp;
    }

    public Integer getCoolMaxTemp() {
        return coolMaxTemp;
    }

    public void setCoolMaxTemp(Integer coolMaxTemp) {
        this.coolMaxTemp = coolMaxTemp;
    }

    public Integer getHeatRangeHigh() {
        return heatRangeHigh;
    }

    public void setHeatRangeHigh(Integer heatRangeHigh) {
        this.heatRangeHigh = heatRangeHigh;
    }

    public Integer getHeatRangeLow() {
        return heatRangeLow;
    }

    public void setHeatRangeLow(Integer heatRangeLow) {
        this.heatRangeLow = heatRangeLow;
    }

    public Integer getCoolRangeHigh() {
        return coolRangeHigh;
    }

    public void setCoolRangeHigh(Integer coolRangeHigh) {
        this.coolRangeHigh = coolRangeHigh;
    }

    public Integer getCoolRangeLow() {
        return coolRangeLow;
    }

    public void setCoolRangeLow(Integer coolRangeLow) {
        this.coolRangeLow = coolRangeLow;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public void setUserAccessCode(String userAccessCode) {
        this.userAccessCode = userAccessCode;
    }

    public Integer getUserAccessSetting() {
        return userAccessSetting;
    }

    public void setUserAccessSetting(Integer userAccessSetting) {
        this.userAccessSetting = userAccessSetting;
    }

    public Integer getAuxRuntimeAlert() {
        return auxRuntimeAlert;
    }

    public void setAuxRuntimeAlert(Integer auxRuntimeAlert) {
        this.auxRuntimeAlert = auxRuntimeAlert;
    }

    public Integer getAuxOutdoorTempAlert() {
        return auxOutdoorTempAlert;
    }

    public void setAuxOutdoorTempAlert(Integer auxOutdoorTempAlert) {
        this.auxOutdoorTempAlert = auxOutdoorTempAlert;
    }

    public Integer getAuxMaxOutdoorTemp() {
        return auxMaxOutdoorTemp;
    }

    public void setAuxMaxOutdoorTemp(Integer auxMaxOutdoorTemp) {
        this.auxMaxOutdoorTemp = auxMaxOutdoorTemp;
    }

    public Boolean getAuxRuntimeAlertNotify() {
        return auxRuntimeAlertNotify;
    }

    public void setAuxRuntimeAlertNotify(Boolean auxRuntimeAlertNotify) {
        this.auxRuntimeAlertNotify = auxRuntimeAlertNotify;
    }

    public Boolean getAuxOutdoorTempAlertNotify() {
        return auxOutdoorTempAlertNotify;
    }

    public void setAuxOutdoorTempAlertNotify(Boolean auxOutdoorTempAlertNotify) {
        this.auxOutdoorTempAlertNotify = auxOutdoorTempAlertNotify;
    }

    public Boolean getAuxRuntimeAlertNotifyTechnician() {
        return auxRuntimeAlertNotifyTechnician;
    }

    public void setAuxRuntimeAlertNotifyTechnician(Boolean auxRuntimeAlertNotifyTechnician) {
        this.auxRuntimeAlertNotifyTechnician = auxRuntimeAlertNotifyTechnician;
    }

    public Boolean getAuxOutdoorTempAlertNotifyTechnician() {
        return auxOutdoorTempAlertNotifyTechnician;
    }

    public void setAuxOutdoorTempAlertNotifyTechnician(Boolean auxOutdoorTempAlertNotifyTechnician) {
        this.auxOutdoorTempAlertNotifyTechnician = auxOutdoorTempAlertNotifyTechnician;
    }

    public Boolean getDisablePreHeating() {
        return disablePreHeating;
    }

    public void setDisablePreHeating(Boolean disablePreHeating) {
        this.disablePreHeating = disablePreHeating;
    }

    public Boolean getDisablePreCooling() {
        return disablePreCooling;
    }

    public void setDisablePreCooling(Boolean disablePreCooling) {
        this.disablePreCooling = disablePreCooling;
    }

    public Boolean getInstallerCodeRequired() {
        return installerCodeRequired;
    }

    public void setInstallerCodeRequired(Boolean installerCodeRequired) {
        this.installerCodeRequired = installerCodeRequired;
    }

    public String getDrAccept() {
        return drAccept;
    }

    public void setDrAccept(String drAccept) {
        this.drAccept = drAccept;
    }

    public Boolean getIsRentalProperty() {
        return isRentalProperty;
    }

    public void setIsRentalProperty(Boolean isRentalProperty) {
        this.isRentalProperty = isRentalProperty;
    }

    public Boolean getUseZoneController() {
        return useZoneController;
    }

    public void setUseZoneController(Boolean useZoneController) {
        this.useZoneController = useZoneController;
    }

    public Integer getRandomStartDelayCool() {
        return randomStartDelayCool;
    }

    public void setRandomStartDelayCool(Integer randomStartDelayCool) {
        this.randomStartDelayCool = randomStartDelayCool;
    }

    public Integer getRandomStartDelayHeat() {
        return randomStartDelayHeat;
    }

    public void setRandomStartDelayHeat(Integer randomStartDelayHeat) {
        this.randomStartDelayHeat = randomStartDelayHeat;
    }

    public Integer getHumidityHighAlert() {
        return humidityHighAlert;
    }

    public void setHumidityHighAlert(Integer humidityHighAlert) {
        this.humidityHighAlert = humidityHighAlert;
    }

    public Integer getHumidityLowAlert() {
        return humidityLowAlert;
    }

    public void setHumidityLowAlert(Integer humidityLowAlert) {
        this.humidityLowAlert = humidityLowAlert;
    }

    public Boolean getDisableHeatPumpAlerts() {
        return disableHeatPumpAlerts;
    }

    public void setDisableHeatPumpAlerts(Boolean disableHeatPumpAlerts) {
        this.disableHeatPumpAlerts = disableHeatPumpAlerts;
    }

    public Boolean getDisableAlertsOnIdt() {
        return disableAlertsOnIdt;
    }

    public void setDisableAlertsOnIdt(Boolean disableAlertsOnIdt) {
        this.disableAlertsOnIdt = disableAlertsOnIdt;
    }

    public Boolean getHumidityAlertNotify() {
        return humidityAlertNotify;
    }

    public void setHumidityAlertNotify(Boolean humidityAlertNotify) {
        this.humidityAlertNotify = humidityAlertNotify;
    }

    public Boolean getHumidityAlertNotifyTechnician() {
        return humidityAlertNotifyTechnician;
    }

    public void setHumidityAlertNotifyTechnician(Boolean humidityAlertNotifyTechnician) {
        this.humidityAlertNotifyTechnician = humidityAlertNotifyTechnician;
    }

    public Boolean getTempAlertNotify() {
        return tempAlertNotify;
    }

    public void setTempAlertNotify(Boolean tempAlertNotify) {
        this.tempAlertNotify = tempAlertNotify;
    }

    public Boolean getTempAlertNotifyTechnician() {
        return tempAlertNotifyTechnician;
    }

    public void setTempAlertNotifyTechnician(Boolean tempAlertNotifyTechnician) {
        this.tempAlertNotifyTechnician = tempAlertNotifyTechnician;
    }

    public Integer getMonthlyElectricityBillLimit() {
        return monthlyElectricityBillLimit;
    }

    public void setMonthlyElectricityBillLimit(Integer monthlyElectricityBillLimit) {
        this.monthlyElectricityBillLimit = monthlyElectricityBillLimit;
    }

    public Boolean getEnableElectricityBillAlert() {
        return enableElectricityBillAlert;
    }

    public void setEnableElectricityBillAlert(Boolean enableElectricityBillAlert) {
        this.enableElectricityBillAlert = enableElectricityBillAlert;
    }

    public Boolean getEnableProjectedElectricityBillAlert() {
        return enableProjectedElectricityBillAlert;
    }

    public void setEnableProjectedElectricityBillAlert(Boolean enableProjectedElectricityBillAlert) {
        this.enableProjectedElectricityBillAlert = enableProjectedElectricityBillAlert;
    }

    public Integer getElectricityBillingDayOfMonth() {
        return electricityBillingDayOfMonth;
    }

    public void setElectricityBillingDayOfMonth(Integer electricityBillingDayOfMonth) {
        this.electricityBillingDayOfMonth = electricityBillingDayOfMonth;
    }

    public Integer getElectricityBillCycleMonths() {
        return electricityBillCycleMonths;
    }

    public void setElectricityBillCycleMonths(Integer electricityBillCycleMonths) {
        this.electricityBillCycleMonths = electricityBillCycleMonths;
    }

    public Integer getElectricityBillStartMonth() {
        return electricityBillStartMonth;
    }

    public void setElectricityBillStartMonth(Integer electricityBillStartMonth) {
        this.electricityBillStartMonth = electricityBillStartMonth;
    }

    public Integer getVentilatorMinOnTimeHome() {
        return ventilatorMinOnTimeHome;
    }

    public void setVentilatorMinOnTimeHome(Integer ventilatorMinOnTimeHome) {
        this.ventilatorMinOnTimeHome = ventilatorMinOnTimeHome;
    }

    public Integer getVentilatorMinOnTimeAway() {
        return ventilatorMinOnTimeAway;
    }

    public void setVentilatorMinOnTimeAway(Integer ventilatorMinOnTimeAway) {
        this.ventilatorMinOnTimeAway = ventilatorMinOnTimeAway;
    }

    public Boolean getBacklightOffDuringSleep() {
        return backlightOffDuringSleep;
    }

    public void setBacklightOffDuringSleep(Boolean backlightOffDuringSleep) {
        this.backlightOffDuringSleep = backlightOffDuringSleep;
    }

    public Boolean getAutoAway() {
        return autoAway;
    }

    public void setAutoAway(Boolean autoAway) {
        this.autoAway = autoAway;
    }

    public Boolean getSmartCirculation() {
        return smartCirculation;
    }

    public void setSmartCirculation(Boolean smartCirculation) {
        this.smartCirculation = smartCirculation;
    }

    public Boolean getFollowMeComfort() {
        return followMeComfort;
    }

    public void setFollowMeComfort(Boolean followMeComfort) {
        this.followMeComfort = followMeComfort;
    }

    public String getVentilatorType() {
        return ventilatorType;
    }

    public void setVentilatorType(String ventilatorType) {
        this.ventilatorType = ventilatorType;
    }

    public Boolean getIsVentilatorTimerOn() {
        return isVentilatorTimerOn;
    }

    public void setIsVentilatorTimerOn(Boolean isVentilatorTimerOn) {
        this.isVentilatorTimerOn = isVentilatorTimerOn;
    }

    public String getVentilatorOffDateTime() {
        return ventilatorOffDateTime;
    }

    public void setVentilatorOffDateTime(String ventilatorOffDateTime) {
        this.ventilatorOffDateTime = ventilatorOffDateTime;
    }

    public Boolean getHasUVFilter() {
        return hasUVFilter;
    }

    public void setHasUVFilter(Boolean hasUVFilter) {
        this.hasUVFilter = hasUVFilter;
    }

    public Boolean getCoolingLockout() {
        return coolingLockout;
    }

    public void setCoolingLockout(Boolean coolingLockout) {
        this.coolingLockout = coolingLockout;
    }

    public Boolean getVentilatorFreeCooling() {
        return ventilatorFreeCooling;
    }

    public void setVentilatorFreeCooling(Boolean ventilatorFreeCooling) {
        this.ventilatorFreeCooling = ventilatorFreeCooling;
    }

    public Boolean getDehumidifyWhenHeating() {
        return dehumidifyWhenHeating;
    }

    public void setDehumidifyWhenHeating(Boolean dehumidifyWhenHeating) {
        this.dehumidifyWhenHeating = dehumidifyWhenHeating;
    }

    public Boolean getVentilatorDehumidify() {
        return ventilatorDehumidify;
    }

    public void setVentilatorDehumidify(Boolean ventilatorDehumidify) {
        this.ventilatorDehumidify = ventilatorDehumidify;
    }

    public String getGroupRef() {
        return groupRef;
    }

    public void setGroupRef(String groupRef) {
        this.groupRef = groupRef;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupSetting() {
        return groupSetting;
    }

    public void setGroupSetting(Integer groupSetting) {
        this.groupSetting = groupSetting;
    }
}
