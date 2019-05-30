package com.thoughtworks.aceleradora.dtos;

import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.Produto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {
    private Long id;
    private String nome;

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public CategoriaDTO() {
    }
    public CategoriaDTO(Categoria categoria) {
        categoria.setId(id);
        categoria.setNome(nome);
        categoria.setProdutos(produtos);

    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
