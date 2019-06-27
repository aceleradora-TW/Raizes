package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.TipoDeUsuario;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.UsuarioRepositorio;
import com.thoughtworks.aceleradora.servicos.UsuarioServico;
import com.thoughtworks.aceleradora.validadores.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioControlador {
    private UsuarioServico usuarioServico;
    private UsuarioValidador usuarioValidador;
    private UsuarioRepositorio repositorio;

    public UsuarioControlador(UsuarioServico usuarioServico, UsuarioValidador usuarioValidador, UsuarioRepositorio repositorio) {
        this.usuarioServico = usuarioServico;
        this.usuarioValidador = usuarioValidador;
        this.repositorio = repositorio;
    }

    @GetMapping(value = "/registrar")
    public String registrar(Model model) {
        model.addAttribute("formUsuario", new Usuario());
        model.addAttribute("tipoUsuario", TipoDeUsuario.values());

        return "registrarUsuario/registrar";
    }

    @PostMapping(value = "/registrar")
    public String registrar(@ModelAttribute("formUsuario") Usuario usuario, BindingResult bindingResult) {
        usuarioValidador.validate(usuario, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registrarUsuario/registrar";
        }

        usuarioServico.salvar(usuario);

        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login(Model modelo) {
        return "login/login";
    }

//    @PostMapping(value = "/login")
//    public String login(@ModelAttribute("formLogin") Usuario usuario) {
//        return "/inicio";
//    }
}
