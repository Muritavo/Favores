package com.paladino.favores.pesistence.entidades;

public class CategoriaHorario {
    private int id;
    private String horario;

    public CategoriaHorario(int id, String horario) {
        this.id = id;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }
}
