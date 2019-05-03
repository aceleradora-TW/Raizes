package com.thoughtworks.aceleradora.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/")
    public String renderizaPaginaInicial() {
        return "inicio";
    }
}
