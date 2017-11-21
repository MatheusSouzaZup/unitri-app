package com.unitriapp.matheus.unitriapp.repository;

import com.unitriapp.matheus.unitriapp.model.response.ResponseError;

/**
 * Created by Matheus on 15/11/2017.
 */

public interface RepositoryCallback<T> {
    void onSuccess(T response);
    void onFail(ResponseError responseError);
}
