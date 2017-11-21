package com.unitriapp.matheus.unitriapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.fragments.chamada.ChamadaFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Matheus on 19/11/2017.
 */

public class TransactionFragment extends Fragment {
    Unbinder unbinder;
    private static String matterID;

    public static TransactionFragment newInstance(String id) {
        matterID = id;
        return new TransactionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        unbinder = ButterKnife.bind(this, view);
        MainActivity.toolbarTitle.setText("Chamada/Avaliação");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_notas, R.id.rl_chamada})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_notas:
                ((MainActivity)getActivity()).replaceFragment(TransactionAvaliacaoFragment.newInstance("5a104979e225fc1a78c016e4"));
                break;
            case R.id.rl_chamada:
                ((MainActivity)getActivity()).replaceFragment(ChamadaFragment.newInstance("5a104979e225fc1a78c016e4"));
                break;
        }
    }
}
