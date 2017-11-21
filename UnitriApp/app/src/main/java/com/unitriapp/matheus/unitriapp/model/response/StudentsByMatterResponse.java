package com.unitriapp.matheus.unitriapp.model.response;

import com.unitriapp.matheus.unitriapp.model.content.Students;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class StudentsByMatterResponse extends BaseResponse {
    List<Students> students;

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
