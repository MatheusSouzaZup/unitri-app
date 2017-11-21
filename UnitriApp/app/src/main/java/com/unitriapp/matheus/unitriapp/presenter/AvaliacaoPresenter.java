package com.unitriapp.matheus.unitriapp.presenter;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.Utils;
import com.unitriapp.matheus.unitriapp.model.response.AvaliacaoByAlunoResponse;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;
import com.unitriapp.matheus.unitriapp.repository.avaliacao.AvaliacaoRepository;
import com.unitriapp.matheus.unitriapp.view.fragments.alunoavaliado.AlunoAvaliadoView;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AvaliacaoPresenter {
    private AlunoAvaliadoView mView;
    private AvaliacaoRepository mRepository;

    public AvaliacaoPresenter(AlunoAvaliadoView view, AvaliacaoRepository repository) {
        mView = view;
        mRepository = repository;
    }
    public void unbind() {
        mView = null;
        mRepository.cancelRequest();
    }
    public void getAvalicaoByAluno(String matter, String aluno) {
        if(mView == null) return;
        mView.showLoading();
        mRepository.getAvalicoesByMatterByAlunoID(matter, aluno, new RepositoryCallback<AvaliacaoByAlunoResponse>() {
            @Override
            public void onSuccess(AvaliacaoByAlunoResponse response) {
                if(mView!=null) {
                    mView.hideLoading();
                    if(response.isSuccess()) {
                        mView.setTotal(Utils.getInstance().getTotalFromAvaliacoes(response.getAvalicoesbyaluno()));
                        mView.initRecycler();
                        mView.initAdapter(response.getAvalicoesbyaluno());
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
