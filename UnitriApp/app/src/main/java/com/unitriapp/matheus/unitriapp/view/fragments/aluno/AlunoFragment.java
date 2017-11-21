package com.unitriapp.matheus.unitriapp.view.fragments.aluno;

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
import com.unitriapp.matheus.unitriapp.model.content.Students;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.presenter.AlunosPresenter;
import com.unitriapp.matheus.unitriapp.repository.chamada.ChamadaHttpRepository;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.adapters.AlunosAdapter;

import java.util.List;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AlunoFragment extends Fragment implements AlunoView {
    private static String matterID;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;
    AlunosPresenter mPresenter;
    Unbinder unbinder;
    static int mFlag;

    public static AlunoFragment newInstance(String id,int flag) {
        matterID = id;
        mFlag = flag;
        return new AlunoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alunos, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new AlunosPresenter(this, new ChamadaHttpRepository());
        mPresenter.getStudents(matterID);
        return view;
    }

    @Override
    public void initRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void initAdapter(List<Students> mList) {
        AlunosAdapter alunosAdapter = new AlunosAdapter(mList,getContext(),matterID,mFlag);
        recyclerView.setAdapter(alunosAdapter);
    }

    @Override
    public void initToolbar() {

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
        Toast.makeText(getContext(),texto, Toast.LENGTH_LONG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
