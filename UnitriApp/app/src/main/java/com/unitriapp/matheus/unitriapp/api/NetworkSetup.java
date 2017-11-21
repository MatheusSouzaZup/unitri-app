package com.unitriapp.matheus.unitriapp.api;

import android.content.Context;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.unitriapp.matheus.unitriapp.UnitriApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Matheus on 15/11/2017.
 */

public class NetworkSetup {
    public static final OkHttpClient getClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(getLoggingInterceptor());
        okHttpClient.connectTimeout(300, TimeUnit.SECONDS);
        okHttpClient.readTimeout(300, TimeUnit.SECONDS);

        Context context = UnitriApplication.getInstance().getApplicationContext();
        CookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        okHttpClient.cookieJar(cookieJar);

        return okHttpClient.build();
    }

    public static Interceptor getLoggingInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }
}
