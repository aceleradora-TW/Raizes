package com.thoughtworks.aceleradora.dominio.excecoes;

public class ProdutoNaoPodeSerNegativoExcecao extends RuntimeException{

    public ProdutoNaoPodeSerNegativoExcecao() {
        super("Valore inválido!");
    }

}
