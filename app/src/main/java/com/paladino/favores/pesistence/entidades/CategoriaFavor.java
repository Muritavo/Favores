package com.paladino.favores.pesistence.entidades;

public class CategoriaFavor{
    private int id;
    private String categoria;

    public CategoriaFavor(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }
}
