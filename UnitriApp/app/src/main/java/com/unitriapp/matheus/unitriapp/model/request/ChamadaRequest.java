package com.unitriapp.matheus.unitriapp.model.request;

import com.unitriapp.matheus.unitriapp.model.content.Chamada;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class ChamadaRequest {
    String matter;
    List<Chamada> students;

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public List<Chamada> getStudents() {
        return students;
    }

    public void setStudents(List<Chamada> students) {
        this.students = students;
    }
}
