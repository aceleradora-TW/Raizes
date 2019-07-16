package com.thoughtworks.aceleradora.dominio.excecoes;

public class EstadoNaoEncontradoExcecao extends RuntimeException{

    public EstadoNaoEncontradoExcecao() {
        super("Estado não encontrado");
    }

}
