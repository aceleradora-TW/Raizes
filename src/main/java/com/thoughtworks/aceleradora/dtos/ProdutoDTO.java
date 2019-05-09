package com.thoughtworks.aceleradora.dtos;

import com.thoughtworks.aceleradora.dominio.Produto;

public class ProdutoDTO extends Produto {

    private boolean checado;

    public ProdutoDTO() {}

    public ProdutoDTO(String nome, boolean checado) {
        super(nome);
        this.checado = checado;
    }

    public boolean isChecado() {
        return checado;
    }


    public void setChecado(boolean checado) {
        this.checado = checado;
    }
}
