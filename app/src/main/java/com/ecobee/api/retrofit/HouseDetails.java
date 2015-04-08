package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/HouseDetails.shtml
 */
public class HouseDetails implements Serializable {

    private String style;
    private Integer size;
    private Integer numberOfFloors;
    private Integer numberOfRooms;
    private Integer numberOfOccupants;
    private Integer age;
    private Integer windowEfficiency;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(Integer numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWindowEfficiency() {
        return windowEfficiency;
    }

    public void setWindowEfficiency(Integer windowEfficiency) {
        this.windowEfficiency = windowEfficiency;
    }
}
