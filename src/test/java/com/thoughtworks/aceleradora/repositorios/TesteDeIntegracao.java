package com.thoughtworks.aceleradora.repositorios;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TesteDeIntegracao.Config.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql(scripts = "/inserir-dados-de-teste.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/limpar-dados-de-teste.sql", executionPhase = AFTER_TEST_METHOD)
public abstract class TesteDeIntegracao {

    @Configuration
    @ComponentScan("com.thoughtworks.aceleradora")
    public static class Config {
    }
}
