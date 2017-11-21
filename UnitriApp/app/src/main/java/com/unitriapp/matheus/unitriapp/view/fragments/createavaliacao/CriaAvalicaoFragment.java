package com.unitriapp.matheus.unitriapp.view.fragments.createavaliacao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CriaAvalicaoFragment extends Fragment implements CreateAvaliacaoView {


    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etValorMaximo)
    EditText etValorMaximo;
    Unbinder unbinder;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;

    public static CriaAvalicaoFragment newInstance() {
        return new CriaAvalicaoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cria_avaliacao_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.btEdit)
    public void onClick() {

    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public Double getMaxValue() {
        return Double.valueOf(etValorMaximo.getText().toString());
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
        Toast.makeText(getContext(),texto,Toast.LENGTH_SHORT).show();
    }
}