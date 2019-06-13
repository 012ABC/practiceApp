package com.dylan.practiceapp.common;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * description
 *
 * @author created by ABC
 * @date 2019/6/4 10:04
 */
public class MyApplication extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public Context getApplicationContext() {

        return this;
    }
}
