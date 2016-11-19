package com.paladino.favores.pesistence.entidades;

public class Avaliacao {
    private int numAvaliacao;
    private int classificacao;
    private String comentario;

    public Avaliacao(int numAvaliacao, int classificacao, String comentario) {
        this.numAvaliacao = numAvaliacao;
        this.classificacao = classificacao;
        this.comentario = comentario;
    }

    public int getNumAvaliacao() {
        return numAvaliacao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getComentario() {
        return comentario;
    }
}
