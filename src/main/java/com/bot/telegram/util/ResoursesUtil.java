package com.bot.telegram.util;

import com.bot.telegram.setting.Settings;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResoursesUtil {
    private static ResourceBundle resource = ResourceBundle.getBundle(Settings.getResourcesFileName());

    public static String getName(String key){
        return resource.getString(key);
    }

    public static void changeLanguage(String language)  {
        resource = ResourceBundle.getBundle(Settings.getResourcesFileName(), new Locale(language));
    }
}
