package com.unitriapp.matheus.unitriapp.model.response;

/**
 * Created by Matheus on 15/11/2017.
 */

public class SignInResponse extends BaseResponse{

    String userID;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
