package com.unitriapp.matheus.unitriapp.repository.chamada;

import com.unitriapp.matheus.unitriapp.api.ApiCreator;
import com.unitriapp.matheus.unitriapp.api.CmsApi;
import com.unitriapp.matheus.unitriapp.model.request.ChamadaRequest;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.model.response.StudentsByMatterResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Matheus on 19/11/2017.
 */

public class ChamadaHttpRepository implements ChamadaRepository {
    Call<StudentsByMatterResponse> studentsByMatterResponseCall;
    Call<SignInResponse> sendResponse;

    @Override
    public void getStudentsByMatter(String id, final RepositoryCallback<StudentsByMatterResponse> repositoryCallback) {
        studentsByMatterResponseCall = ApiCreator.createService(CmsApi.class).getStudentsByMatter(id);
        if(!studentsByMatterResponseCall.isExecuted()) {
            studentsByMatterResponseCall.enqueue(new Callback<StudentsByMatterResponse>() {
                @Override
                public void onResponse(Call<StudentsByMatterResponse> call, Response<StudentsByMatterResponse> response) {
                    if(response.isSuccessful()) {
                        repositoryCallback.onSuccess(response.body());
                    }
                    else{
                        repositoryCallback.onFail(ResponseError.getExceptionError());
                    }
                }

                @Override
                public void onFailure(Call<StudentsByMatterResponse> call, Throwable t) {
                    repositoryCallback.onFail(ResponseError.getExceptionError());
                }
            });
        }
    }

    @Override
    public void sendChamada(ChamadaRequest chamadaRequest, final RepositoryCallback<SignInResponse> repositoryCallback) {
        sendResponse = ApiCreator.createService(CmsApi.class).sendChamada(chamadaRequest);
        if(!sendResponse.isExecuted()) {
            sendResponse.enqueue(new Callback<SignInResponse>() {
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
        if(studentsByMatterResponseCall!= null) {
            studentsByMatterResponseCall.cancel();
            studentsByMatterResponseCall = null;
        }
        if(sendResponse!= null) {
            sendResponse.cancel();
            sendResponse = null;
        }
    }
}
