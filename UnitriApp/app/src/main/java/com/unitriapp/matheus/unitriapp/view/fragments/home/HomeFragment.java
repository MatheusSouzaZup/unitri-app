package com.unitriapp.matheus.unitriapp.view.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.Shifts;
import com.unitriapp.matheus.unitriapp.model.response.MattersResponse;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.presenter.HomePresenter;
import com.unitriapp.matheus.unitriapp.repository.home.HomeMockRepository;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.adapters.HomeAdapter;

import java.util.List;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Matheus on 19/11/2017.
 */

public class HomeFragment extends Fragment implements HomeView{

    @BindView(R.id.rvHome)
    RecyclerView rvHome;
    @BindView(R.id.scrollHome)
    NestedScrollView scrollHome;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;
    Unbinder unbinder;
    HomePresenter mPresenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this,view);
        setUpTitleToolbar();
        mPresenter = new HomePresenter(this, new HomeMockRepository());
        mPresenter.getShifts();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresenter.unbind();
    }

    @Override
    public void showLoading() {
        multiStateLayout.setState(MultiStateLayout.State.LOADING);
    }

    @Override
    public void hideLoading() {
        multiStateLayout.setState(MultiStateLayout.State.CONTENT);
    }

    @Override
    public void showError(ResponseError responseError) {
        multiStateLayout.setState(MultiStateLayout.State.ERROR);
    }

    @Override
    public void showToast(@StringRes int texto) {
        Toast.makeText(getContext(),texto,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setupRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHome.setLayoutManager(linearLayoutManager);
        rvHome.setNestedScrollingEnabled(false);
    }

    @Override
    public void setupAdapter(List<Shifts> shiftsList, List<MattersResponse> mattersResponseList) {
        HomeAdapter mAdapter = new HomeAdapter(getActivity(), shiftsList, mattersResponseList);
        rvHome.setAdapter(mAdapter);
    }

    @Override
    public void setUpTitleToolbar() {
        MainActivity.toolbarTitle.setText(R.string.home);
    }
}
