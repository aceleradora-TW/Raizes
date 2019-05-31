package com.thoughtworks.aceleradora.dtos;


import com.thoughtworks.aceleradora.dominio.Produto;

public class ProdutoDTO  extends Produto {
    private boolean checado;


    public ProdutoDTO(Produto produto, boolean checado) {
        super(
                produto.getId().longValue(),
                produto.getNome(),
                produto.getCategoria(),
                produto.getCultivo()
        );
        this.checado = checado;
    }

    public boolean isChecado() {
        return checado;
    }

    public void setChecado(boolean checado) {
        this.checado = checado;
    }
}
