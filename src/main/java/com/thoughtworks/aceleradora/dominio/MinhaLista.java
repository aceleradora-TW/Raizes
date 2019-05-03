package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="listas")
public class MinhaLista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

//    @ManyToMany(mappedBy = "produtos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "lista_produtos",
            joinColumns = { @JoinColumn(name = "id_lista") },
            inverseJoinColumns = { @JoinColumn(name = "id_produto") }
    )
    @JsonIgnoreProperties("listas")

    private List<Produto> produtos = new ArrayList<>();

    public MinhaLista(){

    }

    public MinhaLista(String nome){
        this.nome = nome;

    }

    public void setId(Long id){
        this.id = id;

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }


}
