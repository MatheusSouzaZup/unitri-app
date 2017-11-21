package com.unitriapp.matheus.unitriapp;

import android.app.Application;

/**
 * Created by Matheus on 15/11/2017.
 */

public class UnitriApplication extends Application {
    public static UnitriApplication mInstance;

    public static UnitriApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
