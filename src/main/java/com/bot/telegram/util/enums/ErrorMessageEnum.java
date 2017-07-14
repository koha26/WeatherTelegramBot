package com.bot.telegram.util.enums;

public enum ErrorMessageEnum {
    CANT_CHANGE_LANGUAGE,
    CANT_OBTAIN_FORECAST,
    CANT_OBTAIN_GEOLOCATION;

    public String getName(){
        return this.name().toLowerCase();
    }
}
