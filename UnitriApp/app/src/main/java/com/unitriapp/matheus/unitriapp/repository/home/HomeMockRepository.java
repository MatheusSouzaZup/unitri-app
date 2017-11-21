package com.unitriapp.matheus.unitriapp.repository.home;

import com.unitriapp.matheus.unitriapp.model.content.Matter;
import com.unitriapp.matheus.unitriapp.model.content.Shifts;
import com.unitriapp.matheus.unitriapp.model.response.MattersResponse;
import com.unitriapp.matheus.unitriapp.model.response.ShiftsResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class HomeMockRepository implements HomeRepository{

    @Override
    public void getShifts(RepositoryCallback<ShiftsResponse> repositoryCallback) {
        repositoryCallback.onSuccess(getMockShifts());
    }

    @Override
    public void getMatters(RepositoryCallback<MattersResponse> repositoryCallback) {
        repositoryCallback.onSuccess(getMockMatters());
    }

    @Override
    public void cancelRequest() {

    }

    public ShiftsResponse getMockShifts() {
        ShiftsResponse mResponse = new ShiftsResponse();
        List<Shifts> mList = new ArrayList<Shifts>();
        mList.add(new Shifts("Manhã"));
        mList.add(new Shifts("Tarde"));
        mList.add(new Shifts("Noite"));

        mResponse.setSuccess(true);
        mResponse.setDate("data");
        mResponse.setShifts(mList);
        return mResponse;
    }
    public MattersResponse getMockMatters() {
        MattersResponse mResponse = new MattersResponse();
        List<Matter> mList = new ArrayList<Matter>();
        mList.add(new Matter("PPI2","1"));
        mList.add(new Matter("PDS","2"));
        mList.add(new Matter("PPI1","3"));
        mResponse.setSuccess(true);
        mResponse.setDate("data");
        mResponse.setMatters(mList);
        return mResponse;
    }
}
