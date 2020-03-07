package com.variant.ktapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.UUID;

public class Settings {
    private static final String PREF_NAME = "com.variant.ktapp.utils.settings";
    private Context context;

    public Settings(Context context) {
        this.context = context;
    }

    private SharedPreferences getPref() {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public String getDeviceId() {
        String value = getPref().getString("DeviceId", "");
        if (value.length() == 0) {
            getPref().edit().putString("DeviceId", UUID.randomUUID().toString()).commit();
            value = getPref().getString("DeviceId", "");
        }
        return value;
    }

    public void setAccessToken(String value) {
        getPref().edit().putString("AccessToken", value).commit();
    }

    public String getAccessToken() {
        String value = getPref().getString("AccessToken", "");
        return value;
    }

}

