package com.paladino.favores.pesistence.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Paladino on 19/11/2016.
 */

public class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private String urlFoto;
    private CategoriaHorario turno;
    private List<Favor> favoresCriados;

    public Pessoa(String nome, String email, CategoriaHorario turno){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.turno = turno;
        favoresCriados = new ArrayList<Favor>();
    }

    public void atualizarPerfil(String nome, String email, String senha, CategoriaHorario turno){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public Enum getTurno() {
        return turno;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public boolean addFavor(Favor favor){
        for (Favor f: favoresCriados) {
            if(!(f.getTitulo().equals(favor.getTitulo()))){
                favoresCriados.add(favor);
                return true;
            }
        }
        return false;
    }
}
