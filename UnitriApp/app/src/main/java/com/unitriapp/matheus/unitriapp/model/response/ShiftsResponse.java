package com.unitriapp.matheus.unitriapp.model.response;

import com.unitriapp.matheus.unitriapp.model.content.Shifts;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class ShiftsResponse extends BaseResponse {
    List<Shifts> shifts;

    public List<Shifts> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shifts> shifts) {
        this.shifts = shifts;
    }
}
