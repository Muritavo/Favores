package com.paladino.favores.pesistence.entidades;

/**
 * Created by Paladino on 19/11/2016.
 */

public class Telefone {
    private int ddd;
    private int telefone;

    public Telefone(int ddd, int telefone) {
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public int getDdd() {
        return ddd;
    }

    public int getTelefone() {
        return telefone;
    }
}
