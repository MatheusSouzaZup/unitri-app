package com.unitriapp.matheus.unitriapp.model.response;

import com.unitriapp.matheus.unitriapp.model.content.AvaliacaoByAluno;

import java.util.List;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AvaliacaoByAlunoResponse extends BaseResponse {
    List<AvaliacaoByAluno> avalicoesbyaluno;

    public List<AvaliacaoByAluno> getAvalicoesbyaluno() {
        return avalicoesbyaluno;
    }

    public void setAvalicoesbyaluno(List<AvaliacaoByAluno> avalicoesbyaluno) {
        this.avalicoesbyaluno = avalicoesbyaluno;
    }
}
