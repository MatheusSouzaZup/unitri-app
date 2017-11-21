package com.unitriapp.matheus.unitriapp.view.fragments.alunoavaliado;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.Utils;
import com.unitriapp.matheus.unitriapp.model.content.AvaliacaoByAluno;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;
import com.unitriapp.matheus.unitriapp.presenter.AlunosPresenter;
import com.unitriapp.matheus.unitriapp.presenter.AvaliacaoPresenter;
import com.unitriapp.matheus.unitriapp.repository.avaliacao.AvaliacaoMockRepository;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.adapters.AvaliacaoAdapter;

import java.util.List;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AlunoAvaliadoFragment extends Fragment implements AlunoAvaliadoView{
    private static String matterID;
    private static String alunoID;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvTotal)
    TextView tvTotal;
    @BindView(R.id.tvPontos)
    TextView tvPontos;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;
    Unbinder unbinder;
    AvaliacaoPresenter mPresenter;


    public static AlunoAvaliadoFragment newInstance(String id, String idAluno) {
        matterID = id;
        alunoID = idAluno;
        return new AlunoAvaliadoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aluno_avaliado, container, false);
        unbinder = ButterKnife.bind(this, view);
        initToolbarTitle();
        mPresenter = new AvaliacaoPresenter(this, new AvaliacaoMockRepository());
        mPresenter.getAvalicaoByAluno(matterID,alunoID);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
        Toast.makeText(getContext(),texto,Toast.LENGTH_LONG);
    }

    @Override
    public void initAdapter(List<AvaliacaoByAluno> mList) {

        AvaliacaoAdapter mAdapter = new AvaliacaoAdapter(mList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void initToolbarTitle() {
        MainActivity.toolbarTitle.setText(R.string.avaliacao);
    }

    @Override
    public void setTotal(double value) {
        tvTotal.setText(getResources().getString(R.string.total));
        tvPontos.setText(String.valueOf(value));
    }
}
