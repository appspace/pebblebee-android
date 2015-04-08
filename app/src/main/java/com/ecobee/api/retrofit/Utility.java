package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Utility.shtml
 */
public class Utility implements Serializable {

    private String name;
    private String phone;
    private String email;
    private String web;

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
}
