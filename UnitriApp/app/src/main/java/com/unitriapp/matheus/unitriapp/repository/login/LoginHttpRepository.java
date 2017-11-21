package com.unitriapp.matheus.unitriapp.repository.login;

import com.unitriapp.matheus.unitriapp.api.ApiCreator;
import com.unitriapp.matheus.unitriapp.api.CmsApi;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.model.request.SignInRequest;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Matheus on 15/11/2017.
 */

public class LoginHttpRepository implements LoginRepository{
    Call<SignInResponse> signInResponseCall;

    @Override
    public void signIn(SignInRequest signInRequest, final RepositoryCallback<SignInResponse> repositoryCallback) {
        signInResponseCall = ApiCreator.createService(CmsApi.class).signIn(signInRequest);
        if(!signInResponseCall.isExecuted()) {
            signInResponseCall.enqueue(new Callback<SignInResponse>() {
                @Override
                public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                    if(response.isSuccessful()) {
                        repositoryCallback.onSuccess(response.body());
                    }
                    else{
                        repositoryCallback.onFail(ResponseError.getExceptionError());
                    }
                }

                @Override
                public void onFailure(Call<SignInResponse> call, Throwable t) {
                    repositoryCallback.onFail(ResponseError.getExceptionError());
                }
            });
        }
    }

    @Override
    public void cancelRequest() {
        if (signInResponseCall.isExecuted()) {
            signInResponseCall.cancel();
            signInResponseCall = null;
        }
    }
}
