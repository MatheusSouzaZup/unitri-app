package com.unitriapp.matheus.unitriapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Matheus on 19/11/2017.
 */

public class UnitriPrefs {
    UnitriPrefs mInstance;
    private final String UNITRI_PREFS = "unitri-prefs";

    public UnitriPrefs getmInstance() {
        if(mInstance ==  null) {
            mInstance = new UnitriPrefs();
        }
        return mInstance;
    }
    private SharedPreferences getSharedPreferences() {
        return UnitriApplication.getInstance().getSharedPreferences(UNITRI_PREFS, Context.MODE_PRIVATE);
    }
    public void save(String key, String value) {
        getSharedPreferences().edit()
                .putString(key, value)
                .apply();
    }
    public String getString(String key) {
        return getSharedPreferences().getString(key, null);
    }
}
