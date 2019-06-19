package com.thoughtworks.aceleradora.dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@Data
@EqualsAndHasghCode(callSuper = true)
@NoArgsConstructor
@Entity

@DiscriminatorValue(TipoDeUsuario.Valores.CLIENTE)
@Table(name = "clientes")
public class Cliente extends Usuario{

    @OneToMany(mappedBy="cliente")
    private List<MinhaLista> minhasListas;

    public Cliente(String email, String senha, String nome, String contato, Endereco endereco, List<MinhaLista> minhasListas) {
        super(email, senha, nome, contato, endereco);
        this.minhasListas = minhasListas;
    }
}
