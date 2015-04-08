package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/SecuritySettings.shtml
 */
public class SecuritySettings implements Serializable {

    private String userAccessCode;
    private Boolean allUserAccess = false;
    private Boolean programAccess = false;
    private Boolean detailsAccess = false;
    private Boolean quickSaveAccess = false;
    private Boolean vacationAccess = false;

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public void setUserAccessCode(String userAccessCode) {
        this.userAccessCode = userAccessCode;
    }

    public Boolean getAllUserAccess() {
        return allUserAccess;
    }

    public void setAllUserAccess(Boolean allUserAccess) {
        this.allUserAccess = allUserAccess;
    }

    public Boolean getProgramAccess() {
        return programAccess;
    }

    public void setProgramAccess(Boolean programAccess) {
        this.programAccess = programAccess;
    }

    public Boolean getDetailsAccess() {
        return detailsAccess;
    }

    public void setDetailsAccess(Boolean detailsAccess) {
        this.detailsAccess = detailsAccess;
    }

    public Boolean getQuickSaveAccess() {
        return quickSaveAccess;
    }

    public void setQuickSaveAccess(Boolean quickSaveAccess) {
        this.quickSaveAccess = quickSaveAccess;
    }

    public Boolean getVacationAccess() {
        return vacationAccess;
    }

    public void setVacationAccess(Boolean vacationAccess) {
        this.vacationAccess = vacationAccess;
    }
}
