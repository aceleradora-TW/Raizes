package com.thoughtworks.aceleradora.dominio;


import com.thoughtworks.aceleradora.validadores.anotacoes.AtualizacaoProdutoValida;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtos_produtores")
@Access(AccessType.FIELD)
@AtualizacaoProdutoValida
public class ProdutoProdutor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer quantidadeEstoque;

    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_produtos")
    Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_produtores")
    Produtor produtor;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_de_cultivo")
    private TipoDeCultivo tipoDeCultivo;

    public ProdutoProdutor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public TipoDeCultivo getTipoDeCultivo() {
        return tipoDeCultivo;
    }

    public void setTipoDeCultivo(TipoDeCultivo tipoDeCultivo) {
        this.tipoDeCultivo = tipoDeCultivo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
