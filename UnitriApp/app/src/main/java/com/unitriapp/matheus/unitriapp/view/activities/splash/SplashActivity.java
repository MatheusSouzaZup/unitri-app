package com.unitriapp.matheus.unitriapp.view.activities.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.view.activities.login.LoginActivity;

/**
 * Created by Matheus on 15/11/2017.
 */

public class SplashActivity extends AppCompatActivity implements SplashView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_splash);
        showLogin();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(ResponseError responseError) {

    }

    @Override
    public void showToast(@StringRes int text) {

    }

    @Override
    public void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showHome() {

    }
}
