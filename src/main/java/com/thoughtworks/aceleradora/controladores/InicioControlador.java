package com.thoughtworks.aceleradora.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class InicioControlador  extends MainController{

    public InicioControlador() { }

    @GetMapping("/")
    public String renderizaPaginaInicial(Model model) {
        return this.go("inicio", "Inicio", model);
    }
}
