package com.unitriapp.matheus.unitriapp.presenter;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.Shifts;
import com.unitriapp.matheus.unitriapp.model.response.MattersResponse;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.model.response.ShiftsResponse;
import com.unitriapp.matheus.unitriapp.repository.home.HomeRepository;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;
import com.unitriapp.matheus.unitriapp.view.fragments.home.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */


public class HomePresenter {
    private HomeView mView;
    private HomeRepository mRepository;
    int cont;
    private List<MattersResponse> matterList;
    private List<Shifts> shiftsList;

    public HomePresenter(HomeView view, HomeRepository repository) {
        mView = view;
        mRepository = repository;
        matterList = new ArrayList<>();
        shiftsList = new ArrayList<>();
        cont = 0;
    }

    public void unbind() {
        mView = null;
        mRepository.cancelRequest();
    }

    public void getShifts() {
        if (mView == null) return;
        mView.showLoading();
        mRepository.getShifts(new RepositoryCallback<ShiftsResponse>() {
            @Override
            public void onSuccess(ShiftsResponse response) {
                if (mView != null) {
                    if (response.isSuccess()) {
                        shiftsList = response.getShifts();
                        getMatters(response.getShifts());
                    } else {
                        mView.showToast(R.string.unexpected_error);
                    }
                }
            }

            @Override
            public void onFail(ResponseError responseError) {
                if (mView != null) {
                    mView.hideLoading();
                    mView.showError(responseError);
                }
            }
        });
    }

    private void getMatters(final List<Shifts> mList) {
        if (mView == null) return;
        for (Shifts s : mList) {
            mRepository.getMatters(new RepositoryCallback<MattersResponse>() {
                @Override
                public void onSuccess(MattersResponse response) {
                    cont++;
                    matterList.add(response);
                    if (cont == mList.size()) {
                        mView.hideLoading();
                        setupView();
                    }
                }

                @Override
                public void onFail(ResponseError responseError) {
                    mView.hideLoading();
                    mView.showError(responseError);
                }
            });
        }
    }
    private void setupView() {
        mView.setupRecycler();
        mView.setupAdapter(shiftsList,matterList);
    }
}
