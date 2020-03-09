package com.variant.ktapp;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.L;
import com.variant.ktapp.utils.Settings;

public class App extends Application {

    private Settings settings;
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initializeUIL();
    }


    private void initializeUIL() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .cacheOnDisk(true).cacheInMemory(true)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .considerExifParams(true).build())
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();
        if (BuildConfig.DEBUG) {
            L.writeLogs(true);
            L.writeDebugLogs(true);
        }
        ImageLoader.getInstance().init(config);
    }

    public Settings getSettings() {
        if (settings == null) {
            settings = new Settings(this);
        }
        return settings;
    }
}
