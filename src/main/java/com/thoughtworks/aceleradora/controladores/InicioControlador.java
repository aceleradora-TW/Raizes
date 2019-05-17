package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/")
    public String renderizaPaginaInicial(Breadcrumb breadcrumb) {
        breadcrumb
                .pagina("Início", "/");

        return "inicio";
    }
}
