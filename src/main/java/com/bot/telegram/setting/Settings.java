package com.bot.telegram.setting;

public class Settings {
    public static final String EOL = System.lineSeparator();

    private static final String DARK_SKY_API_KEY = "4b2cc574a09c5a8360c233cb4a04ef36";
    private static final String GOOGLE_MAPS_API_KEY = "AIzaSyCpukuuYDKq096JmdleGoYaIQD0Zulu-DI";
    private static final String RESOURCES_FILE_NAME = "weather";

    public static String getDarkSkyApiKey() {
        return DARK_SKY_API_KEY;
    }

    public static String getGoogleMapsApiKey() {
        return GOOGLE_MAPS_API_KEY;
    }

    public static String getResourcesFileName() {
        return RESOURCES_FILE_NAME;
    }
}
