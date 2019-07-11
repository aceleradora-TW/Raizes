package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.TipoDeUsuario;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.CidadeRepositorio;
import com.thoughtworks.aceleradora.repositorios.EstadoRepositorio;
import com.thoughtworks.aceleradora.repositorios.UsuarioRepositorio;
import com.thoughtworks.aceleradora.servicos.RegistrarServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UsuarioControlador {
    private RegistrarServico registrarServico;
    private CidadeRepositorio cidadeRepositorio;
    private EstadoRepositorio estadoRepositorio;
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioControlador(RegistrarServico registrarServico,
                              CidadeRepositorio cidadeRepositorio,
                              EstadoRepositorio estadoRepositorio,
                              UsuarioRepositorio usuarioRepositorio) {
        this.registrarServico = registrarServico;
        this.cidadeRepositorio = cidadeRepositorio;
        this.estadoRepositorio = estadoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @GetMapping(value = "/registrar/cliente")
    public String registrarCliente(Model model) {
        model.addAttribute("formCliente", new Cliente());
        model.addAttribute("cidade", cidadeRepositorio.findAll());
        model.addAttribute("estado", estadoRepositorio.findAll());

        return "registro/registrarCliente";
    }

    @GetMapping(value = "/registrar/produtor")
    public String registrarProdutor(Model model) {
        model.addAttribute("formProd", new Produtor());
        model.addAttribute("cidade", cidadeRepositorio.findAll());
        model.addAttribute("estado", estadoRepositorio.findAll());

        return "registro/registrarProdutor";
    }


    @GetMapping(value = "/seleciona-tipo-usuario")
    public String selecionaUsuario(){
        return "registro/selecionaUsuario";
    }


    @PostMapping(value = "/registrar/cliente")
    public String registrarCliente(@ModelAttribute("formCliente") @Valid Cliente cliente, BindingResult bindingResult, Model modelo) {

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("erros", bindingResult.getAllErrors());
            bindingResult.getAllErrors().forEach(System.out::println);
            return "registro/registrarCliente";
        }

        registrarServico.salvarCliente(cliente);

        return "redirect:/login";
    }

    @PostMapping(value = "/registrar/produtor")
    public String registrarProdutor(@ModelAttribute("formProd") @Valid Produtor produtor, BindingResult bindingResult, Model modelo) {
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("erros", bindingResult.getAllErrors());
            return "registro/registrarProdutor";
        }

        registrarServico.salvarProdutor(produtor);

        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login(Model modelo) {
        return "login/login";
    }

}

