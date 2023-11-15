package com.example.costaricatravel.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class Language {
    private static Language _instance;
    private String PREFERENCES = "CostaRicaTravelPrefStorage";
    private String LANGUAGE_PREFERENCE = "LanguageSetUp";

    public static Language getInstance() {
        if(_instance == null){
            _instance = new Language();
        }
        return _instance;
    }

    public void setLocale(Activity activity, String languageCode, Boolean updateDefault) {
        SharedPreferences preferences = activity.getApplicationContext().getSharedPreferences(PREFERENCES, 0);
        if(updateDefault){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(LANGUAGE_PREFERENCE, languageCode);
            editor.commit();
        }

        String newlanguageCode = preferences.getString(LANGUAGE_PREFERENCE,languageCode);
        Locale locale = new Locale(newlanguageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
