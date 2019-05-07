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
@RequestMapping("/minhalista")
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

        modelo.addAttribute("produtos", produtoServico.getAll());
        return "minhaLista/cadastro";
    }

    @PostMapping("/previa")
    public String previaLista(MinhaLista lista, Model modelo,  HttpSession sessao) {
        modelo.addAttribute("minhaLista", lista);
        sessao.setAttribute("minhaLista", lista);
        return "minhaLista/previa";
    }


    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista) {
        MinhaLista novalista = minhaListaServico.salvar(lista);

        return "minhaLista/previa";
    }


    public String salvarMinhaListaNaSessao(MinhaLista minhaLista, HttpSession session) {
        session.setAttribute("minhaLista", minhaLista);

        MinhaLista minhaListaNaSession = (MinhaLista) session.getAttribute("minhaLista");
        return null;
    }

}

