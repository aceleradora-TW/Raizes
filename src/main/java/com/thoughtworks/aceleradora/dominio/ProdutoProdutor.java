package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtos_produtores")
@Access(AccessType.FIELD)
public class ProdutoProdutor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private double quantidadeEstoque;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_produtos")
    Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_produtores")
    Produtor produtor;

    public ProdutoProdutor() {
    }

    public ProdutoProdutor(double quantidadeEstoque, BigDecimal preco, Produto produto, Produtor produtor) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.produto = produto;
        this.produtor = produtor;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
