package com.thoughtworks.aceleradora.dominio.excecoes;

public class ClienteNaoEncontradoExcecao extends RuntimeException{

    public ClienteNaoEncontradoExcecao() {
        super("Cliente não encontrado");
    }

}
