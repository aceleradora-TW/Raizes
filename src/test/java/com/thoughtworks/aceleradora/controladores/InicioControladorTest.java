package com.thoughtworks.aceleradora.controladores;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InicioControladorTest {

    @Test
    public void renderizaPaginaInicio() {
        InicioControlador inicioControlador = new InicioControlador();

        assertEquals("inicio", inicioControlador.renderizaPaginaInicial());
    }
}
