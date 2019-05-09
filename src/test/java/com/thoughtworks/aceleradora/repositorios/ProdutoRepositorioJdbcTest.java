package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ProdutoRepositorioJdbcTest.Config.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql(scripts = "/inserir-produtos-de-teste.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/limpar-dados-de-teste.sql", executionPhase = AFTER_TEST_METHOD)
public class ProdutoRepositorioJdbcTest {

    @Configuration
    @ComponentScan("com.thoughtworks.aceleradora")
    public static class Config {
    }

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