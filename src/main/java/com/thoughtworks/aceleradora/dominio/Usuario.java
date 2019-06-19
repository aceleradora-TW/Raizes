package com.thoughtworks.aceleradora.dominio;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_de_usuario")
@Entity
@Table(name = "usuarios")

abstract class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String senha;
    private String nome;
    private String contato;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario", insertable = false, updatable = false)
    private TipoDeUsuario tipoDeUsuario;

    public Usuario(String email, String senha, String nome, String contato, Endereco endereco) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
    }
}

