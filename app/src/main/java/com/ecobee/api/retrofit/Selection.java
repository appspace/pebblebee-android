package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-02-19.

 * The selection object defines the resources and information to return
 * as part of a response. The selection is required in all requests
 * however meaning of some selection fields is only meaningful to
 * certain types of requests.
 * The selectionType parameter defines the type of selection to perform.
 * The selectionMatch specifies the matching criteria for the type
 * specified.
 */
public class Selection implements Serializable {

    private SelectionType selectionType;
    private String selectionMatch;
    private Boolean includeRuntime;
    private Boolean includeExtendedRuntime;
    private Boolean includeElectricity;
    private Boolean includeSettings;
    private Boolean includeLocation;
    private Boolean includeProgram;
    private Boolean includeEvents;
    private Boolean includeDevice;
    private Boolean includeTechnician;
    private Boolean includeUtility;
    private Boolean includeManagement;
    private Boolean includeAlerts;
    private Boolean includeWeather;
    private Boolean includeHouseDetails;
    private Boolean includeOemCfg;
    private Boolean includeEquipmentStatus;
    private Boolean includeNotificationSettings;
    private Boolean includePrivacy;
    private Boolean includeVersion;
    private Boolean includeSecuritySettings;

    public SelectionType getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(SelectionType selectionType) {
        this.selectionType = selectionType;
    }

    public String getSelectionMatch() {
        return selectionMatch;
    }

    public void setSelectionMatch(String selectionMatch) {
        this.selectionMatch = selectionMatch;
    }

    public Boolean getIncludeRuntime() {
        return includeRuntime;
    }

    public void setIncludeRuntime(Boolean includeRuntime) {
        this.includeRuntime = includeRuntime;
    }

    public Boolean getIncludeExtendedRuntime() {
        return includeExtendedRuntime;
    }

    public void setIncludeExtendedRuntime(Boolean includeExtendedRuntime) {
        this.includeExtendedRuntime = includeExtendedRuntime;
    }

    public Boolean getIncludeElectricity() {
        return includeElectricity;
    }

    public void setIncludeElectricity(Boolean includeElectricity) {
        this.includeElectricity = includeElectricity;
    }

    public Boolean getIncludeSettings() {
        return includeSettings;
    }

    public void setIncludeSettings(Boolean includeSettings) {
        this.includeSettings = includeSettings;
    }

    public Boolean getIncludeLocation() {
        return includeLocation;
    }

    public void setIncludeLocation(Boolean includeLocation) {
        this.includeLocation = includeLocation;
    }

    public Boolean getIncludeProgram() {
        return includeProgram;
    }

    public void setIncludeProgram(Boolean includeProgram) {
        this.includeProgram = includeProgram;
    }

    public Boolean getIncludeEvents() {
        return includeEvents;
    }

    public void setIncludeEvents(Boolean includeEvents) {
        this.includeEvents = includeEvents;
    }

    public Boolean getIncludeDevice() {
        return includeDevice;
    }

    public void setIncludeDevice(Boolean includeDevice) {
        this.includeDevice = includeDevice;
    }

    public Boolean getIncludeTechnician() {
        return includeTechnician;
    }

    public void setIncludeTechnician(Boolean includeTechnician) {
        this.includeTechnician = includeTechnician;
    }

    public Boolean getIncludeUtility() {
        return includeUtility;
    }

    public void setIncludeUtility(Boolean includeUtility) {
        this.includeUtility = includeUtility;
    }

    public Boolean getIncludeManagement() {
        return includeManagement;
    }

    public void setIncludeManagement(Boolean includeManagement) {
        this.includeManagement = includeManagement;
    }

    public Boolean getIncludeAlerts() {
        return includeAlerts;
    }

    public void setIncludeAlerts(Boolean includeAlerts) {
        this.includeAlerts = includeAlerts;
    }

    public Boolean getIncludeWeather() {
        return includeWeather;
    }

    public void setIncludeWeather(Boolean includeWeather) {
        this.includeWeather = includeWeather;
    }

    public Boolean getIncludeHouseDetails() {
        return includeHouseDetails;
    }

    public void setIncludeHouseDetails(Boolean includeHouseDetails) {
        this.includeHouseDetails = includeHouseDetails;
    }

    public Boolean getIncludeOemCfg() {
        return includeOemCfg;
    }

    public void setIncludeOemCfg(Boolean includeOemCfg) {
        this.includeOemCfg = includeOemCfg;
    }

    public Boolean getIncludeEquipmentStatus() {
        return includeEquipmentStatus;
    }

    public void setIncludeEquipmentStatus(Boolean includeEquipmentStatus) {
        this.includeEquipmentStatus = includeEquipmentStatus;
    }

    public Boolean getIncludeNotificationSettings() {
        return includeNotificationSettings;
    }

    public void setIncludeNotificationSettings(Boolean includeNotificationSettings) {
        this.includeNotificationSettings = includeNotificationSettings;
    }

    public Boolean getIncludePrivacy() {
        return includePrivacy;
    }

    public void setIncludePrivacy(Boolean includePrivacy) {
        this.includePrivacy = includePrivacy;
    }

    public Boolean getIncludeVersion() {
        return includeVersion;
    }

    public void setIncludeVersion(Boolean includeVersion) {
        this.includeVersion = includeVersion;
    }

    public Boolean getIncludeSecuritySettings() {
        return includeSecuritySettings;
    }

    public void setIncludeSecuritySettings(Boolean includeSecuritySettings) {
        this.includeSecuritySettings = includeSecuritySettings;
    }
}
