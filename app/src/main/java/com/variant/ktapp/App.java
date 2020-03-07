package com.variant.ktapp;

import android.app.Application;

import com.variant.ktapp.utils.Settings;

public class App extends Application {

    private Settings settings;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public Settings getSettings() {
        if (settings == null) {
            settings = new Settings(this);
        }
        return settings;
    }
}
