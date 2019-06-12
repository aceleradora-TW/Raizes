package com.thoughtworks.aceleradora.dominio.excecoes;

public class ListaNaoEncontradaExcecao extends RuntimeException {

    public ListaNaoEncontradaExcecao() {
        super("Lista não encontrada!");
    }
}