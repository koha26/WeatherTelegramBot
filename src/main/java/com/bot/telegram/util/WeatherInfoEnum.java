package com.bot.telegram.util;

public enum WeatherInfoEnum {
    LOCATION,
    DATE,
    TEMPERATURE,
    TIME,
    WIND,
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
    CLOUD_COVER;

    public String getName(){
        return this.name().toLowerCase();
    }

}
