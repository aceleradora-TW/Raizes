package com.thoughtworks.aceleradora.login.controladores;

import com.thoughtworks.aceleradora.login.dominio.Usuario;
import com.thoughtworks.aceleradora.login.servicos.UsuarioServico;
import com.thoughtworks.aceleradora.login.validador.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginControlador {
    private UsuarioValidador usuarioValidador;
    private UsuarioServico usuarioServico;

    @Autowired
    public LoginControlador(UsuarioValidador usuarioValidador, UsuarioServico usuarioServico) {
        this.usuarioValidador = usuarioValidador;
        this.usuarioServico = usuarioServico;
    }
    @GetMapping(value = "/login")
    public String login() {
        return "login/login";
    }

    @GetMapping(value = "/bemvindo")
    public String bemVindo(@ModelAttribute Usuario usuario) {
        return "bemvindo/bemvindo";
    }

    @GetMapping(value = "/admin")
    public String paginaAdmin() {
        return "admin";
    }
}





