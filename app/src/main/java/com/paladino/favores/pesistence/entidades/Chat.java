package com.paladino.favores.pesistence.entidades;

/**
 * Created by Paladino on 19/11/2016.
 */

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
