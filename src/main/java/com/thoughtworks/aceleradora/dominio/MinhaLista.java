package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "listas")
public class MinhaLista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "lista_produtos",
            joinColumns = {@JoinColumn(name = "id_lista")},
            inverseJoinColumns = {@JoinColumn(name = "id_produto")}
    )

    @JsonIgnoreProperties("listas")
    private List<Produto> produtos = new ArrayList<>();

    public MinhaLista() {

    }

    public MinhaLista(String nome) {
        this.nome = nome;
    }

    public MinhaLista(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public MinhaLista(Long id, String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinhaLista that = (MinhaLista) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(produtos, that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, produtos);
    }

    @Override
    public String toString() {
        return "MinhaLista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", produtos=" + produtos +
                '}';
    }
}
