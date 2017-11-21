package com.unitriapp.matheus.unitriapp.view.fragments.chamada;

import com.unitriapp.matheus.unitriapp.model.content.Students;
import com.unitriapp.matheus.unitriapp.view.BaseView;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public interface ChamadaView extends BaseView {
    void setUpRecycler();
    void setUpAdapter(List<Students> students);
    void setUpToolbarTitle();
    void getbackHome();
}
