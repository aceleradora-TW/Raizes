package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtos_produtor")
@Access(AccessType.FIELD)
public class ProdutoProdutor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private double preco;
    private double qtdEstoque;

    @ManyToOne
    @JoinColumn(name = "id_produtos")
    Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_produtor")
    Produtor produtor;

    public ProdutoProdutor() {
    }

    public ProdutoProdutor(double preco, double qtdEstoque, Produto produto, Produtor produtor) {
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.produto = produto;
        this.produtor = produtor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return "ProdutoProdutor{" +
                "id=" + id +
                ", preco=" + preco +
                ", qtdEstoque=" + qtdEstoque +
                ", produto=" + produto +
                ", produtor=" + produtor +
                '}';
    }
}
