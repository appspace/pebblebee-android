package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Location.shtml
 */
public class Location implements Serializable {

    private Integer timeZoneOffsetMinutes;
    private String timeZone;
    private Boolean isDaylightSaving;
    private String streetAddress;
    private String city;
    private String provinceState;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String mapCoordinates;

    public Integer getTimeZoneOffsetMinutes() {
        return timeZoneOffsetMinutes;
    }

    public void setTimeZoneOffsetMinutes(Integer timeZoneOffsetMinutes) {
        this.timeZoneOffsetMinutes = timeZoneOffsetMinutes;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getIsDaylightSaving() {
        return isDaylightSaving;
    }

    public void setIsDaylightSaving(Boolean isDaylightSaving) {
        this.isDaylightSaving = isDaylightSaving;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMapCoordinates() {
        return mapCoordinates;
    }

    public void setMapCoordinates(String mapCoordinates) {
        this.mapCoordinates = mapCoordinates;
    }
}
