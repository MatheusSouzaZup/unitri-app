package com.unitriapp.matheus.unitriapp.view.fragments.home;

import com.unitriapp.matheus.unitriapp.model.content.Shifts;
import com.unitriapp.matheus.unitriapp.model.response.MattersResponse;
import com.unitriapp.matheus.unitriapp.view.BaseView;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public interface HomeView extends BaseView {
    void setupRecycler();
    void setupAdapter(List<Shifts> shiftsList, List<MattersResponse> mattersResponseList);
    void setUpTitleToolbar();
}
