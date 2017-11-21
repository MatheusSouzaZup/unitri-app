package com.unitriapp.matheus.unitriapp.presenter;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.model.response.StudentsByMatterResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;
import com.unitriapp.matheus.unitriapp.repository.chamada.ChamadaRepository;
import com.unitriapp.matheus.unitriapp.view.fragments.aluno.AlunoView;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AlunosPresenter {
    private AlunoView mView;
    private ChamadaRepository mRepository;

    public AlunosPresenter(AlunoView view, ChamadaRepository repository) {
        mView = view;
        mRepository = repository;
    }
    public void unbinder() {
        mView = null;
        mRepository.cancelRequest();
    }
    public void getStudents(String matterID) {
        if(mView == null) return;
        mView.showLoading();
        mRepository.getStudentsByMatter(matterID, new RepositoryCallback<StudentsByMatterResponse>() {
            @Override
            public void onSuccess(StudentsByMatterResponse response) {
                if(mView!=null) {
                    mView.hideLoading();
                    if (response.isSuccess()) {
                        mView.initRecycler();
                        mView.initAdapter(response.getStudents());
                    }
                    else{
                        mView.showToast(R.string.unexpected_error);
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
