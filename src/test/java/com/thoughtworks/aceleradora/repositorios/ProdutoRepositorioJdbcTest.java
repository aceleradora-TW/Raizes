package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProdutoRepositorioJdbcTest extends TesteDeIntegracao {

    @Autowired
    private ProdutoRepositorioJdbc repositorioJdbc;

    @Test
    public void encontraTodosOsProdutosDisponiveis() {

        List<Produto> resultado = repositorioJdbc.buscarTodos();

        assertThat(resultado, is(List.of(
                new Produto(1L, "Banana"),
                new Produto(2L, "Maca"),
                new Produto(3L, "Batata")
        )));
    }

    @Test
    public void encontraUmProdutoPorId() {
        Optional<Produto> batata = repositorioJdbc.buscarPorId(3L);

        assertThat(batata.get(), is(new Produto(3L, "Batata")));
    }

    @Test
    public void quandoRegistroNaoExisteRetornaOpcionalVazio() {
        Optional<Produto> produtoInexistente = repositorioJdbc.buscarPorId(100L);

        assertThat(produtoInexistente.isPresent(), is(false));
    }

    @Test
    public void insereUmNovoRegistro() {
       repositorioJdbc.inserir(new Produto("Banana"));

       assertThat(repositorioJdbc.buscarPorId(4L).get(), is(new Produto(4L, "Banana")));
    }
}