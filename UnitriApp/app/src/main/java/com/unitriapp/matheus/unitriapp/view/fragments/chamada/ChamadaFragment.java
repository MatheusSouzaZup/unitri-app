package com.unitriapp.matheus.unitriapp.view.fragments.chamada;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.Utils;
import com.unitriapp.matheus.unitriapp.model.content.Students;
import com.unitriapp.matheus.unitriapp.model.request.ChamadaRequest;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.presenter.ChamadaPresenter;
import com.unitriapp.matheus.unitriapp.repository.chamada.ChamadaHttpRepository;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.adapters.ChamadaAdapter;
import com.unitriapp.matheus.unitriapp.view.fragments.home.HomeFragment;

import java.util.List;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Matheus on 19/11/2017.
 */

public class ChamadaFragment extends Fragment implements ChamadaView {
    private static String matterID;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;
    ChamadaAdapter mAdapter;
    ChamadaPresenter mPresenter;
    public static ChamadaFragment newInstance(String id) {
        matterID = id;
        return new ChamadaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chamada, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter  = new ChamadaPresenter(this, new ChamadaHttpRepository());
        mPresenter.getStudentsByMatter(matterID);
        setUpToolbarTitle();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresenter.Unbinder();
    }

    @OnClick(R.id.send)
    public void onClick() {
        ChamadaRequest mRequest = new ChamadaRequest();
        if(mAdapter!= null) {
            mRequest = Utils.getInstance().parseStudentsByMatterToChamadaRequest(mAdapter.getList(),matterID);
            mPresenter.sendChamada(mRequest);
        }

    }

    @Override
    public void setUpRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void setUpAdapter(List<Students> students)  {
        mAdapter = new ChamadaAdapter(students);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setUpToolbarTitle() {
        MainActivity.toolbarTitle.setText(R.string.chamada);
    }

    @Override
    public void getbackHome() {
        ((MainActivity)getActivity()).replaceFragment(HomeFragment.newInstance());
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
}
