package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/EquipmentSetting.shtml
 */
public class EquipmentSetting {

    private String filterLastChanged;
    private Integer filterLife;
    private String filterLifeUnits;
    private String remindMeDate;

    private Boolean enabled;
    private String type;
    private Boolean remindTechnician;

    public String getFilterLastChanged() {
        return filterLastChanged;
    }

    public void setFilterLastChanged(String filterLastChanged) {
        this.filterLastChanged = filterLastChanged;
    }

    public Integer getFilterLife() {
        return filterLife;
    }

    public void setFilterLife(Integer filterLife) {
        this.filterLife = filterLife;
    }

    public String getFilterLifeUnits() {
        return filterLifeUnits;
    }

    public void setFilterLifeUnits(String filterLifeUnits) {
        this.filterLifeUnits = filterLifeUnits;
    }

    public String getRemindMeDate() {
        return remindMeDate;
    }

    public void setRemindMeDate(String remindMeDate) {
        this.remindMeDate = remindMeDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRemindTechnician() {
        return remindTechnician;
    }

    public void setRemindTechnician(Boolean remindTechnician) {
        this.remindTechnician = remindTechnician;
    }
}
