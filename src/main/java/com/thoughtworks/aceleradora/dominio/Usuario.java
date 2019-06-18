package com.thoughtworks.aceleradora.dominio;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(unique = true)
    private String email;

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

