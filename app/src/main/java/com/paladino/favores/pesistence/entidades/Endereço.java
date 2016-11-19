package com.paladino.favores.pesistence.entidades;

public class Endereço {
    private int numero;
    private String rua;
    private String cidade;
    private String cep;
    private String estado;

    public Endereço(int numero, String rua, String cidade, String cep, String estado) {
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }
    
    
}
