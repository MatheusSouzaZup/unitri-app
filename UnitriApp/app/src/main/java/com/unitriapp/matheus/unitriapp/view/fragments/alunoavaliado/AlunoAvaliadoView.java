package com.unitriapp.matheus.unitriapp.view.fragments.alunoavaliado;

import com.unitriapp.matheus.unitriapp.model.content.AvaliacaoByAluno;
import com.unitriapp.matheus.unitriapp.view.BaseView;

import java.util.List;

/**
 * Created by Matheus on 20/11/2017.
 */

public interface AlunoAvaliadoView extends BaseView{
    void initAdapter(List<AvaliacaoByAluno> mList);
    void initRecycler();
    void initToolbarTitle();
    void setTotal(double value);
}
