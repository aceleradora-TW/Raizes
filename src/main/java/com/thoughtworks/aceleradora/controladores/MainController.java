package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
    private Breadcrumb breadcrumb;
    public MainController() {
        this.breadcrumb = new Breadcrumb();
    }

    public String go(String page, String pageTitle, Model model) {
        if(!breadcrumb.get().contains(pageTitle))
        this.breadcrumb.add(pageTitle);
        model.addAttribute("breadcrumb", this.breadcrumb.get());
        return page;
    }

}
