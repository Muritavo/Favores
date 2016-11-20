package com.paladino.favores.pesistence.entidades;

public enum CategoriaHorario {
    Manha(1), Tarde(2), Noite(3);

    public int id;

    CategoriaHorario(int id){
        this.id = id;
    }
}
