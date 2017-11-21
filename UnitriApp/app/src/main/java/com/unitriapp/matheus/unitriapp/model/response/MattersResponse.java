package com.unitriapp.matheus.unitriapp.model.response;

import com.unitriapp.matheus.unitriapp.model.content.Matter;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class MattersResponse extends BaseResponse{
    List<Matter> matters;

    public List<Matter> getMatters() {
        return matters;
    }

    public void setMatters(List<Matter> matters) {
        this.matters = matters;
    }
}
