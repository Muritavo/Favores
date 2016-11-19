
package com.paladino.favores.pesistence.entidades;

public class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private String urlFoto;
    private Enum turno;
    
    public Pessoa(String nome, String email, String senha, Enum turno){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.turno = turno;
    }
    
    public void atualizarPerfil(String nome, String email, String senha, Enum turno){
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
}
