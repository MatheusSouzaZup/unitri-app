package com.unitriapp.matheus.unitriapp.model.content;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AvaliacaoByAluno {
    String nome;
    String pontos;

    public AvaliacaoByAluno(String nome, String pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }
    public AvaliacaoByAluno() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
}
