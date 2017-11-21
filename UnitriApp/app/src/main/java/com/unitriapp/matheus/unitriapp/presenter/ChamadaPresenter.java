package com.unitriapp.matheus.unitriapp.presenter;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.request.ChamadaRequest;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.model.response.StudentsByMatterResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;
import com.unitriapp.matheus.unitriapp.repository.chamada.ChamadaRepository;
import com.unitriapp.matheus.unitriapp.view.fragments.chamada.ChamadaView;

/**
 * Created by Matheus on 19/11/2017.
 */

public class ChamadaPresenter {
    ChamadaView mView;
    ChamadaRepository mRepository;

    public ChamadaPresenter(ChamadaView view, ChamadaRepository repository) {
        mView = view;
        mRepository = repository;
    }
    public void Unbinder() {
        mView = null;
        mRepository.cancelRequest();
    }
    public void getStudentsByMatter(String matterid) {
        if(mView == null) return;
        mView.showLoading();
        mRepository.getStudentsByMatter(matterid, new RepositoryCallback<StudentsByMatterResponse>() {
            @Override
            public void onSuccess(StudentsByMatterResponse response) {
                if(mView != null) {
                    mView.hideLoading();
                    if (response.isSuccess()) {
                        mView.setUpRecycler();
                        mView.setUpAdapter(response.getStudents());

                    } else {
                        mView.showToast(R.string.unexpected_error);
                    }
                }
            }

            @Override
            public void onFail(ResponseError responseError) {
                    if(mView!= null){
                        mView.hideLoading();
                        mView.showError(responseError);
                    }
            }
        });
    }
    public void sendChamada(ChamadaRequest chamadaRequest) {
        if(mView == null) return;
        mView.showLoading();
        mRepository.sendChamada(chamadaRequest, new RepositoryCallback<SignInResponse>() {
            @Override
            public void onSuccess(SignInResponse response) {
                if(mView!= null) {
                    mView.hideLoading();
                    mView.getbackHome();
                    mView.showToast(R.string.success);
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
