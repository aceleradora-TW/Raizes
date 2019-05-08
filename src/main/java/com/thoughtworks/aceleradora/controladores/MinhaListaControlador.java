package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/minha-lista")
public class MinhaListaControlador {

    private ProdutoServico produtoServico;
    private MinhaListaServico minhaListaServico;

    @Autowired
    public MinhaListaControlador(ProdutoServico produtoServico, MinhaListaServico minhaListaServico) {
        this.produtoServico = produtoServico;
        this.minhaListaServico = minhaListaServico;
    }


    @GetMapping("/cadastro")
    public String criarLista(Model modelo) {

        modelo.addAttribute("produtos", produtoServico.pegarTodos());
        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro")
    public String previaLista(HttpSession sessao) {
        MinhaLista lista = (MinhaLista) sessao.getAttribute("minhaLista");
        MinhaLista novaLista = minhaListaServico.salvar(lista);

        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro/previa")
    public String salvarLista(MinhaLista lista, Model modelo, HttpSession sessao) {
        modelo.addAttribute("minhaLista", lista);
        sessao.setAttribute("minhaLista", lista);
        return "minhaLista/previa";
    }
}

