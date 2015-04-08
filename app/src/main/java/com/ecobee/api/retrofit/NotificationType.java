package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-04-08.
 */
public enum NotificationType {

    ALERT("alert"),
    HVAC("1hvac"),
    FURNANCE_FILTER("furnaceFilter"),
    HUMIDIFIER_FILTER("humidifierFilter"),
    DEHUMIDIFIER_FILTER("dehumidifierFilter"),
    VENTILATOR("ventilator"),
    AC("ac"),
    AIR_FILTER("airFilter"),
    AIR_CLEANER("airCleaner"),
    UV_LAMP("uvLamp"),
    TEMP("temp"),
    LOW_TEMP("lowTemp"),
    HIGH_TEMP("highTemp"),
    LOW_HUMIDITY("lowHumidity"),
    HIGH_HUMIDITY("highHumidity"),
    AUX_HEAT("auxHeat"),
    AUX_OUTDOOR("auxOutdoor");

    private final String _jsonValue;

    NotificationType(String jsonValue) {
        _jsonValue = jsonValue;
    }
}
