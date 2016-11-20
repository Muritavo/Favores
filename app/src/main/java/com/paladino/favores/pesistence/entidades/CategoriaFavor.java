package com.paladino.favores.pesistence.entidades;

/**
 * Created by Paladino on 19/11/2016.
 */

public enum CategoriaFavor {
   Pintura(1), Jardinagem(2), Conserto(3);

    public int id;

    CategoriaFavor(int id){
        this.id = id;
    }
}
