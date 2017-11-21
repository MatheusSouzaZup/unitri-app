package com.unitriapp.matheus.unitriapp.repository.login;

import com.unitriapp.matheus.unitriapp.model.request.SignInRequest;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

/**
 * Created by Matheus on 15/11/2017.
 */

public interface LoginRepository {
    void signIn(SignInRequest signInRequest, RepositoryCallback<SignInResponse> repositoryCallback);
    void cancelRequest();
}
