package com.thoughtworks.aceleradora.pessoa.dominio;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private Pessoa(){}

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return String.format("[%s]", Stream.of(nome, sobrenome).collect(joining(" ")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(sobrenome, pessoa.sobrenome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, sobrenome);
    }
}
