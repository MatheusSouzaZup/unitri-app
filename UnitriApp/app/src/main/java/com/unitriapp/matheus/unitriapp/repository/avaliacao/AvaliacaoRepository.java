package com.unitriapp.matheus.unitriapp.repository.avaliacao;

import com.unitriapp.matheus.unitriapp.model.response.AvaliacaoByAlunoResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

/**
 * Created by Matheus on 20/11/2017.
 */

public interface AvaliacaoRepository {
    void getAvalicoesByMatterByAlunoID(String matter, String aluno, RepositoryCallback<AvaliacaoByAlunoResponse> repositoryCallback);
    void cancelRequest();
}
