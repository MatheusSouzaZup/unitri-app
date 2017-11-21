package com.unitriapp.matheus.unitriapp.repository.avaliacao;

import com.unitriapp.matheus.unitriapp.model.content.AvaliacaoByAluno;
import com.unitriapp.matheus.unitriapp.model.response.AvaliacaoByAlunoResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AvaliacaoMockRepository implements AvaliacaoRepository {

    @Override
    public void getAvalicoesByMatterByAlunoID(String matter, String aluno, RepositoryCallback<AvaliacaoByAlunoResponse> repositoryCallback) {
        repositoryCallback.onSuccess(getMockAvalicaoAluno());
    }

    @Override
    public void cancelRequest() {

    }

    public AvaliacaoByAlunoResponse getMockAvalicaoAluno() {
        AvaliacaoByAlunoResponse mResponse = new AvaliacaoByAlunoResponse();
        List<AvaliacaoByAluno> mList = new ArrayList();
        mResponse.setSuccess(true);
        mResponse.setDate("hoje");
        mList.add(new AvaliacaoByAluno("V1","10"));
        mList.add(new AvaliacaoByAluno("V2","10"));
        mList.add(new AvaliacaoByAluno("V3","10"));
        mResponse.setAvalicoesbyaluno(mList);
        return mResponse;
    }
}
