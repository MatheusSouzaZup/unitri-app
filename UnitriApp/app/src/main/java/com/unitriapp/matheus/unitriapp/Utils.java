package com.unitriapp.matheus.unitriapp;

import com.unitriapp.matheus.unitriapp.model.content.AvaliacaoByAluno;
import com.unitriapp.matheus.unitriapp.model.content.Chamada;
import com.unitriapp.matheus.unitriapp.model.content.Students;
import com.unitriapp.matheus.unitriapp.model.request.ChamadaRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class Utils {
    private static Utils mInstance;

    public static Utils getInstance() {
        if (mInstance == null) {
            mInstance = new Utils();
        }

        return mInstance;
    }
    public ChamadaRequest parseStudentsByMatterToChamadaRequest(List<Students> mList,String matterID) {
        ChamadaRequest mRequest = new ChamadaRequest();
        List<Chamada> chamadaList = new ArrayList<>();
        Chamada chamada;
        mRequest.setMatter(matterID);
        for(Students s : mList) {
            chamada = new Chamada();
            chamada.setId(s.getId());
            chamada.setPresent(s.isPresent());
            chamadaList.add(chamada);
        }
        mRequest.setStudents(chamadaList);
        return mRequest;
    }
    public Double getTotalFromAvaliacoes(List<AvaliacaoByAluno> mList) {
        Double value = 0.0;
        for(AvaliacaoByAluno x: mList) {
            value += Double.valueOf(x.getPontos());
        }
        return value;
    }
    public List<String> getAvaliacoes() {
        List<String> mList = new ArrayList<>();
        mList.add("V1");
        mList.add("V2");
        mList.add("VT");
        mList.add("Interdisciplinar");
        return mList;
    }
}
