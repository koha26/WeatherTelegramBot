package com.bot.telegram.util.enums;

public enum OutInfoEnum {
    ENTER_DATA,
    START_MENU,
    LANGUAGE,
    LANGUAGE_CHANGED;

    public String getName(){
        return this.name().toLowerCase();
    }
}
