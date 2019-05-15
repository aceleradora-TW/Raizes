package com.thoughtworks.aceleradora.classeDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "lista_produtos")

public class ListaProdutoDTO {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id",updatable=true,nullable=false)
    private Long id;
    @Column(name="id_lista",updatable=true,nullable=false)
    private Long id_lista;
    @Column(name="id_produto",updatable=true,nullable=false)
    private Long id_produto;

    public ListaProdutoDTO(){

    }

    public long getId() {
        return id;
    }

    public long getId_lista() {
        return id_lista;
    }

    public long getId_produto() {
        return id_produto;
    }
}
