package com.unitriapp.matheus.unitriapp.repository.home;

import com.unitriapp.matheus.unitriapp.model.response.MattersResponse;
import com.unitriapp.matheus.unitriapp.model.response.ShiftsResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

/**
 * Created by Matheus on 19/11/2017.
 */

public interface HomeRepository {
    void getShifts(RepositoryCallback<ShiftsResponse> repositoryCallback);
    void getMatters(RepositoryCallback<MattersResponse> repositoryCallback);
    void cancelRequest();
}
