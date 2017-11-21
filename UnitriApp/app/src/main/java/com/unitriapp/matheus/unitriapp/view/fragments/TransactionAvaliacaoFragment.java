package com.unitriapp.matheus.unitriapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.fragments.aluno.AlunoFragment;
import com.unitriapp.matheus.unitriapp.view.fragments.createavaliacao.CriaAvalicaoFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Matheus on 20/11/2017.
 */

public class TransactionAvaliacaoFragment extends Fragment {
    Unbinder unbinder;
    private static String matterID;

    public static TransactionAvaliacaoFragment newInstance(String id) {
        matterID = id;
        return new TransactionAvaliacaoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_avaliacao, container, false);
        MainActivity.toolbarTitle.setText(R.string.avaliacao);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_avaliar, R.id.rl_criar_avaliacao, R.id.rl_alunos_avaliados})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_avaliar:
                ((MainActivity)getActivity()).replaceFragment(AlunoFragment.newInstance(matterID,1));
                break;
            case R.id.rl_criar_avaliacao:
                ((MainActivity)getActivity()).replaceFragment(CriaAvalicaoFragment.newInstance());
                break;
            case R.id.rl_alunos_avaliados:
                ((MainActivity)getActivity()).replaceFragment(AlunoFragment.newInstance(matterID,2));
                break;
        }
    }
}
