package com.paladino.favores.pesistence.entidades;

public class Chat {
    private Mensagem mensagem;
    private Pessoa usuario;

    public Chat(Mensagem mensagem, Pessoa usuario) {
        this.mensagem = mensagem;
        this.usuario = usuario;
    }
    
    public Mensagem getMensagem() {
        return mensagem;
    }

    public Pessoa getUsuario() {
        return usuario;
    }
}
