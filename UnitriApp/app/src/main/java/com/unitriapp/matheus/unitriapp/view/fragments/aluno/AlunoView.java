package com.unitriapp.matheus.unitriapp.view.fragments.aluno;

import com.unitriapp.matheus.unitriapp.model.content.Students;
import com.unitriapp.matheus.unitriapp.view.BaseView;

import java.util.List;

/**
 * Created by Matheus on 20/11/2017.
 */

public interface AlunoView extends BaseView{
    void initRecycler();
    void initAdapter(List<Students> mList);
    void initToolbar();
}
