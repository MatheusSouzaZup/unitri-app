package com.unitriapp.matheus.unitriapp.repository.chamada;

import com.unitriapp.matheus.unitriapp.model.request.ChamadaRequest;
import com.unitriapp.matheus.unitriapp.model.response.SignInResponse;
import com.unitriapp.matheus.unitriapp.model.response.StudentsByMatterResponse;
import com.unitriapp.matheus.unitriapp.repository.RepositoryCallback;

/**
 * Created by Matheus on 19/11/2017.
 */

public interface ChamadaRepository {
    void getStudentsByMatter(String id, RepositoryCallback<StudentsByMatterResponse> repositoryCallback);
    void sendChamada(ChamadaRequest chamadaRequest, RepositoryCallback<SignInResponse> repositoryCallback);
    void cancelRequest();
}
