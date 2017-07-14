package com.bot.telegram.command;

public enum CommandEnum {
    WEATHER("/weather"),
    WEATHER_7("/weather7"),
    WEATHER_2("/weather2"),
    START("/start"),
    LANGUAGE("/lan");

    private String name;
    CommandEnum(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name.toLowerCase();
    }
}
