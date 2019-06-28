package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pagina;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InicioControladorTest {

    private InicioControlador inicioControlador;

    @Before
    public void setUp() {
        inicioControlador = new InicioControlador();
    }

    @Test
    public void renderizaPaginaInicio() {
        assertEquals("inicio", inicioControlador.renderizaPaginaInicial(new Breadcrumb()));
    }

    @Test
    public void criaBreadcrumbComPaginaDeInicio() {
        Breadcrumb breadcrumb = new Breadcrumb();

        inicioControlador.renderizaPaginaInicial(breadcrumb);
        Pagina paginaInicial = breadcrumb.getPaginas().get(0);

        assertThat(paginaInicial.getUrl(), is("/"));
        assertThat(paginaInicial.getTitulo(), is("Página Inicial"));
    }

}
