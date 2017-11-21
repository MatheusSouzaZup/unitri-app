package com.unitriapp.matheus.unitriapp.model.response;

/**
 * Created by Matheus on 19/11/2017.
 */

public class BaseResponse {
    boolean success;
    String date;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
