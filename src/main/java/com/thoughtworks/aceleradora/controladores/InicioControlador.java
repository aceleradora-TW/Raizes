package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Pagina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InicioControlador {

    private Breadcrumb breadcrumb;

    public InicioControlador() {
        this.breadcrumb = new Breadcrumb();
    }

    @GetMapping("/")
    public String renderizaPaginaInicial(Model modelo) {
        List<Pagina> listaDePaginas = breadcrumb.criaBreadcrumb("Página Inicial", "/", modelo);
        modelo.addAttribute("listaDePaginas", listaDePaginas);

        return "inicio";
    }

}
