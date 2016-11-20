package com.paladino.favores.pesistence.entidades;

/**
 * Created by Paladino on 19/11/2016.
 */

public class Favor {
    private int ID;
    private Pessoa criadora;
    private String titulo;
    private String descricao;
    private Status status;
    private CategoriaHorario turno;

    public Favor(int ID, String titulo, String descricao, Pessoa pessoa, CategoriaHorario turno){
        this.ID = ID;
        this.titulo = titulo;
        this.descricao = descricao;
        status = Status.Novo;
        this.turno = turno;
    }

    public String getTitulo(){
        return titulo;
    }

    public  String getDescricao(){
        return descricao;
    }

    public int getID(){
        return ID;
    }

    public Pessoa getCriadora(){
        return criadora;
    }

    public CategoriaHorario getTurno() {
        return turno;
    }
}
