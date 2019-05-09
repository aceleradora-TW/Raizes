package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MinhaListaRepositorioJdbcTest extends TesteDeIntegracao {

    @Autowired
    private MinhaListaRepositorioJdbc repositorioJdbc;

    @Test
    public void encontraUmaListaFazendoJuncaoDeSeusProdutosCorretamente() {
        Optional<MinhaLista> minhaLista = repositorioJdbc.buscarPorId(1L);

        assertThat(minhaLista.get(), is(new MinhaLista(1L, "Uma lista", List.of(
                new Produto(1L, "Banana"),
                new Produto(2L, "Maca"),
                new Produto(3L, "Batata")

        ))));
    }
}