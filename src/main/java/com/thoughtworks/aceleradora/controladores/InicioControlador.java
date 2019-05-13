package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.servicos.BreadcrumbServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    private BreadcrumbServico breadcrumbServico;

    public InicioControlador(BreadcrumbServico breadcrumbServico) {
        this.breadcrumbServico = breadcrumbServico;
    }

    @GetMapping("/")
    public String renderizaPaginaInicial(Model modelo) {

        return this.breadcrumbServico.renderizaBreadcrumb("Página Inicial","inicio", "/", modelo);
    }

}
