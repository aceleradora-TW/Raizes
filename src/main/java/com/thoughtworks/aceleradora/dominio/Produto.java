package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "produtos")
@Access(AccessType.FIELD)
public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;


    @ManyToOne
    @JoinColumn(name = "id_categorias")
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;


    @Enumerated
    private UnidadeDeMedida unidadeDeMedida;

    public Produto(String nome) {
    }

    public Produto() {}


    public Produto(String nome, Categoria categoria, UnidadeDeMedida unidadeDeMedida) {
        this.nome = nome;
        this.categoria = categoria;
        this.unidadeDeMedida = unidadeDeMedida;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public String toString() {
        return nome;
    }

}

