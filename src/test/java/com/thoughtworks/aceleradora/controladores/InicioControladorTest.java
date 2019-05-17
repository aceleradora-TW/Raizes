package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InicioControladorTest {

    @Test
    public void renderizaPaginaInicio() {
        InicioControlador inicioControlador = new InicioControlador();

        assertEquals("inicio", inicioControlador.renderizaPaginaInicial(new Breadcrumb()));
    }
}
