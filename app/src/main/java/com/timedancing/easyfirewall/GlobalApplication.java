package com.timedancing.easyfirewall;

import android.app.Application;

/**
 * Created by zengzheying on 16/1/7.
 */
public class GlobalApplication extends Application {

    private static GlobalApplication sInstance;

    public static GlobalApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
