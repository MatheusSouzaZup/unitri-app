package com.unitriapp.matheus.unitriapp.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Matheus on 15/11/2017.
 */

public class ApiCreator {
    private static String API_BASE_URL_CMS = "http://192.168.0.15:3000/";
    private static OkHttpClient okHttpClient = NetworkSetup.getClient();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL_CMS)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(okHttpClient).build();
        return retrofit.create(serviceClass);
    }
}
