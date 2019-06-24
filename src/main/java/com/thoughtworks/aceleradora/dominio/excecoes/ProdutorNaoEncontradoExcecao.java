package com.thoughtworks.aceleradora.dominio.excecoes;

public class ProdutorNaoEncontradoExcecao extends RuntimeException{
    public ProdutorNaoEncontradoExcecao() {
        super("Produtor não encontrado");
    }
}
