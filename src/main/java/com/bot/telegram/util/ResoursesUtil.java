package com.bot.telegram.util;

import com.bot.telegram.setting.Settings;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResoursesUtil {
    private static ResourceBundle resource = ResourceBundle.getBundle(Settings.getResourcesFileName());

    public static String getName(String key){
        return resource.getString(key);
    }

    public static Locale getLocale(){
        return resource.getLocale();
    }

    public static void changeLanguage(String language)  {
        Locale locale = new Locale.Builder().setLanguage(language).build();
        resource = ResourceBundle.getBundle(Settings.getResourcesFileName(), locale);
    }
}
