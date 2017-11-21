package com.unitriapp.matheus.unitriapp.presenter;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.request.SignInRequest;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.repository.login.LoginRepository;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;
import com.unitriapp.matheus.unitriapp.view.activities.login.LoginView;

/**
 * Created by Matheus on 15/11/2017.
 */

public class LoginPresenter {
    private LoginView mView;
    private LoginRepository mRepository;

    public LoginPresenter(LoginView view,LoginRepository repository ) {
        mView = view;
        mRepository = repository;
    }

    public void unbind() {
        mView = null;
        mRepository.cancelRequest();
    }
    public void singIn(SignInRequest signInRequest) {
        if(mView == null) return;
        mView.showLoading();
        mRepository.signIn(signInRequest, new RepositoryCallback<SignInResponse>() {
            @Override
            public void onSuccess(SignInResponse response) {
                if(mView!= null ) {
                    if(response.isSuccess()) {
                        mView.hideLoading();
                        mView.showToast(R.string.success);
                        mView.showHome();
                    }
                    else{
                        mView.hideLoading();
                        mView.showToast(R.string.invalid_infos);
                        mView.clear();
                    }
                }
            }

            @Override
            public void onFail(ResponseError responseError) {
                if(mView!= null) {
                    mView.hideLoading();
                    mView.showError(responseError);
                }
            }
        });
    }
}
