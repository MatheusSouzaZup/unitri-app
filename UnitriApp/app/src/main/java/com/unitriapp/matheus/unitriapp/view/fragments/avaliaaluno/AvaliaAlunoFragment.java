package com.unitriapp.matheus.unitriapp.view.fragments.avaliaaluno;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.Utils;
import com.unitriapp.matheus.unitriapp.model.response.ResponseError;

import java.util.List;

import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Matheus on 21/11/2017.
 */

public class AvaliaAlunoFragment extends Fragment implements AvaliaAlunoView{
    private static String matterID;
    private static String alunoID;
    @BindView(R.id.spinnerAvaliacao)
    Spinner spinnerAvaliacao;
    @BindView(R.id.etPontuacao)
    EditText etPontuacao;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;
    Unbinder unbinder;

    public static AvaliaAlunoFragment newInstance(String id, String idAluno) {
        matterID = id;
        alunoID = idAluno;
        return new AvaliaAlunoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.avalia_aluno_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initSpinner(Utils.getInstance().getAvaliacoes());
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
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(ResponseError responseError) {

    }

    @Override
    public void showToast(@StringRes int texto) {

    }

    @Override
    public void initSpinner(List<String> mList) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, mList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerAvaliacao.setAdapter(arrayAdapter);
    }
}
