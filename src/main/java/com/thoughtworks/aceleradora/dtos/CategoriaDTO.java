package com.thoughtworks.aceleradora.dtos;

import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.Produto;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDTO {
    private Long id;
    private String nome;
    private List<ProdutoDTO> produtos;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.produtos = mapeiaProdutosParaDto(categoria.getProdutos());
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

    private List<ProdutoDTO> mapeiaProdutosParaDto(List<Produto> produtos) {
        return produtos.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
    }
}
