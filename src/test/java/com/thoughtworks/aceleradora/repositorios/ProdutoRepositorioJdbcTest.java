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

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ProdutoRepositorioJdbcTest.Config.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql("/test-produtos-data.sql")
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

        assertThat(resultado, is(asList(
                new Produto(1L, "Banana"),
                new Produto(2L, "Maca"),
                new Produto(3L, "Batata")
        )));

    }
}