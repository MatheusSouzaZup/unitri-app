package com.unitriapp.matheus.unitriapp.view;

import android.support.annotation.StringRes;

import com.unitriapp.matheus.unitriapp.model.response.ResponseError;

/**
 * Created by Matheus on 15/11/2017.
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showError(ResponseError responseError);
    void showToast(@StringRes int texto);
}
