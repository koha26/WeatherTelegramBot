package com.bot.telegram.util.enums;

public enum WeatherInfoEnum {
    LOCATION,
    DATE,
    TEMPERATURE,
    TIME,
    WINDY,
    HUMIDITY,
    VISIBILITY,
    PRESSURE,
    NOW,
    SUNRISE_TIME,
    SUNSET_TIME,
    TEMPERATURE_MIN,
    TEMPERATURE_MAX,
    TEMPERATURE_MIN_TIME,
    TEMPERATURE_MAX_TIME,
    CLOUD_COVER,
    FORECAST_7,
    FORECAST_2;

    public String getName(){
        return this.name().toLowerCase();
    }

}
