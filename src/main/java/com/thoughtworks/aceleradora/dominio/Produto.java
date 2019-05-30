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

    @ManyToOne
    @JoinColumn(name = "id_tipos_de_cultivos" )
    @JsonIgnoreProperties("produtos")
    private Cultivo cultivo;

    public Produto(String nome) {
    }

    public Produto() {}

    public Produto(Long id, String nome, Categoria categoria, Cultivo cultivo) {
        this.nome = nome;
        this.categoria = categoria;
        this.cultivo = cultivo;
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

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    public String toString() {
        return nome;
    }

}

