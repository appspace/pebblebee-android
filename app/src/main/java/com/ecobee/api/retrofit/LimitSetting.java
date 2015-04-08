package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-04-08.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/LimitSetting.shtml
 */
public class LimitSetting {

    private Integer limit;
    private Boolean enabled;
    private String type;
    private Boolean remindTechnician;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
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
