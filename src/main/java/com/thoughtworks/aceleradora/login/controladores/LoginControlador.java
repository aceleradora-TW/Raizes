package com.thoughtworks.aceleradora.login.controladores;

import com.thoughtworks.aceleradora.login.dominio.TipoDeUsuario;
import com.thoughtworks.aceleradora.login.dominio.Usuario;
import com.thoughtworks.aceleradora.login.servicos.UsuarioServico;
import com.thoughtworks.aceleradora.login.validador.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginControlador {
    private UsuarioValidador usuarioValidador;
    private UsuarioServico usuarioServico;

    @Autowired
    public LoginControlador(UsuarioValidador usuarioValidador, UsuarioServico usuarioServico) {
        this.usuarioValidador = usuarioValidador;
        this.usuarioServico = usuarioServico;
    }

    @GetMapping(value = "/registrar")
    public String registrar(Model model) {
        model.addAttribute("formUsuario", new Usuario());
        model.addAttribute("cargos", TipoDeUsuario.values());

        return "registrarUsuario/registrar";
    }

    @PostMapping(value = "/registrar")
    public String registrar(@ModelAttribute("formUsuario") Usuario usuario, BindingResult bindingResult) {
        usuarioValidador.validate(usuario, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registrarUsuario/usuarioError";
        }

        usuarioServico.salvar(usuario);

        return "registrarUsuario/usuarioSalvo";
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





