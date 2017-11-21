package com.unitriapp.matheus.unitriapp.model.content;

/**
 * Created by Matheus on 19/11/2017.
 */

public class Shifts {
    String turno;

    public Shifts(String turno) {
        this.turno = turno;
    }
    public Shifts() {

    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
