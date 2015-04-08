package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/NotificationSettings.shtml
 */
public class NotificationSettings implements Serializable {

    private String[] emailAddresses;
    private Boolean emailNotificationsEnabled;
    private EquipmentSetting[] equipment;
    private GeneralSetting[] general;
    private LimitSetting[] limit;

    public String[] getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(String[] emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public Boolean getEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

    public EquipmentSetting[] getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentSetting[] equipment) {
        this.equipment = equipment;
    }

    public GeneralSetting[] getGeneral() {
        return general;
    }

    public void setGeneral(GeneralSetting[] general) {
        this.general = general;
    }

    public LimitSetting[] getLimit() {
        return limit;
    }

    public void setLimit(LimitSetting[] limit) {
        this.limit = limit;
    }
}
