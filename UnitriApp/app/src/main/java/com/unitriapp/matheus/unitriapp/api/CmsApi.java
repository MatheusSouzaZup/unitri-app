package com.unitriapp.matheus.unitriapp.api;

import com.unitriapp.matheus.unitriapp.model.request.ChamadaRequest;
import com.unitriapp.matheus.unitriapp.model.request.SignInRequest;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.model.response.StudentsByMatterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Matheus on 15/11/2017.
 */

public interface CmsApi {
    @POST("signin")
    Call<SignInResponse> signIn(@Body SignInRequest signInRequest);

    @GET("studentsbymatter/{idmatter}")
    Call<StudentsByMatterResponse> getStudentsByMatter(@Path("idmatter") String id_matter);

    @POST("addpresencecontrol")
    Call<SignInResponse> sendChamada(@Body ChamadaRequest request);

}
