package com.thoughtworks.aceleradora.dominio;

import org.junit.Test;

import java.util.function.Consumer;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class BreadcrumbTest {

    @Test
    public void constroiListaDeLinksCorretamente() {
        Breadcrumb breadcrumb = new Breadcrumb();

        breadcrumb
                .pagina("Inicio", "/")
                .pagina("Listas", "/minha-lista")
                .pagina("Lista do Silva", "/minha-lista/1");

        assertThat(breadcrumb.toString(), is("Inicio > Listas > Lista do Silva"));
    }

    @Test
    public void permiteConstruirPaginasDeManeiraLazyRecebendoUmConsumer() {

        Breadcrumb breadcrumb = new Breadcrumb();

        Consumer<Breadcrumb> construtorPreguicoso = (crumbs) -> crumbs
                .pagina("Inicio", "/")
                .pagina("Listas", "/minha-lista");

        breadcrumb
                .aproveitar(construtorPreguicoso)
                .pagina("Cadastro", "/minha-lista/criar");

        assertThat(breadcrumb.toString(), is("Inicio > Listas > Cadastro"));
    }

    @Test
    public void validaCorretamenteQueUmaPaginaEstaAtiva() {
        Breadcrumb breadcrumb = new Breadcrumb();

        breadcrumb
                .pagina("Inicio", "/")
                .pagina("Listas", "/minha-lista")
                .pagina("Lista do Silva", "/minha-lista/1");

        assertTrue(breadcrumb.ehPaginaAtiva(new Pagina("Lista do Silva", "/minha-lista/1")));
        assertFalse(breadcrumb.ehPaginaAtiva(new Pagina("Inicio", "/")));
    }
}