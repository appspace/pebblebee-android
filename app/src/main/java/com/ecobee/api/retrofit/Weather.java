package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Weather.shtml
 */
public class Weather implements Serializable {

    private String timestamp;
    private String weatherStation;
    private WeatherForecast[] forecasts;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(String weatherStation) {
        this.weatherStation = weatherStation;
    }

    public WeatherForecast[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(WeatherForecast[] forecasts) {
        this.forecasts = forecasts;
    }
}
