package com.thoughtworks.aceleradora.pessoa.controllers;

import com.thoughtworks.aceleradora.home.controllers.InicioController;
import org.junit.Test;

import static org.junit.Assert.*;

public class InicioControllerTest {

    @Test
    public void renderizaPaginaInicio() {
        InicioController inicioController = new InicioController();

        assertEquals("inicio", inicioController.renderizaPaginaInicial());
    }
}
