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

@DiscriminatorValue(TipoDeUsuario.Valores.PRODUTOR)
@Table(name = "produtores")
public class Produtor extends Usuario{

    private boolean possuiTransporte;

    public Produtor(String email, String senha, String nome, String contato, Endereco endereco, boolean possuiTransporte) {
        super(email, senha, nome, contato, endereco);
        this.possuiTransporte = possuiTransporte;
    }
}