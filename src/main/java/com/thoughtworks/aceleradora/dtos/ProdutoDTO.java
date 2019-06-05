package com.thoughtworks.aceleradora.dtos;


import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.Cultivo;
import com.thoughtworks.aceleradora.dominio.Produto;

public class ProdutoDTO {
    private Cultivo cultivo;
    private Categoria categoria;
    private String nome;
    private long id;
    private boolean checado;


    public ProdutoDTO(Produto produto, boolean checado) {

        this.id = produto.getId();
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.cultivo = produto.getCultivo();
        this.checado = checado;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.cultivo = produto.getCultivo();
        this.checado = false;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isChecado() {
        return checado;
    }

    public void setChecado(boolean checado) {
        this.checado = checado;
    }
}
