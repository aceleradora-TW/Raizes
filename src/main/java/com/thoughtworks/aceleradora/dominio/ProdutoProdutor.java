package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.HALF_EVEN;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtos_produtores")
@Access(AccessType.FIELD)
public class ProdutoProdutor {

    private static final int DUAS_CASAS_APOS_A_VIRGULA = 2;

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

    public ProdutoProdutor(Integer quantidadeEstoque, BigDecimal preco,
                           Produto produto, Produtor produtor,
                           TipoDeCultivo tipoDeCultivo) {

        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.produto = produto;
        this.produtor = produtor;
        this.tipoDeCultivo = tipoDeCultivo;
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
       return preco.setScale(DUAS_CASAS_APOS_A_VIRGULA, HALF_EVEN);
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
