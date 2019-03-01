package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.Pessoa;
import com.thoughtworks.aceleradora.dominio.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaRepository repositorio;

    public PessoaController(PessoaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/cadastro")
    public String formularioCadastro() {
        return "pessoa/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvaCadastro(Pessoa pessoa) {

        repositorio.save(pessoa);

        return "redirect:lista";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("pessoas", repositorio.findAll());

        return "pessoa/lista";
    }

}
