package com.thoughtworks.aceleradora.dominio;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BreadcrumbTest {

    @Test
    public void name() {
        Breadcrumb breadcrumb = new Breadcrumb();

        breadcrumb
                .pagina("Inicio", "/")
                .pagina("Listas", "/minha-lista")
                .pagina("Lista do Silva", "/minha-lista/1");

        assertThat(breadcrumb.toString(), is("Inicio > Listas > Lista do Silva"));
    }
}