package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Management.shtml
 */
public class Management implements Serializable {

    private String administrativeContact;
    private String billingContact;
    private String name;
    private String phone;
    private String email;
    private String web;
    private Boolean showAlertIdt;
    private Boolean showAlertWeb;

    public String getAdministrativeContact() {
        return administrativeContact;
    }

    public void setAdministrativeContact(String administrativeContact) {
        this.administrativeContact = administrativeContact;
    }

    public String getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(String billingContact) {
        this.billingContact = billingContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Boolean getShowAlertIdt() {
        return showAlertIdt;
    }

    public void setShowAlertIdt(Boolean showAlertIdt) {
        this.showAlertIdt = showAlertIdt;
    }

    public Boolean getShowAlertWeb() {
        return showAlertWeb;
    }

    public void setShowAlertWeb(Boolean showAlertWeb) {
        this.showAlertWeb = showAlertWeb;
    }
}
