package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public String criarLista(Model model) {

        model.addAttribute("produtos", produtoServico.pegarTodos());
        return "minhaLista/cadastro";
    }


    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista) {

        minhaListaServico.salvar(lista);
        return "minhaLista/cadastro";
    }

    @GetMapping("/editar-lista/{id}")
    public String pegaLista(Model modelo, @PathVariable("id") Long id) {
        Optional<MinhaLista> lista = minhaListaServico.encontraUm(id);

        modelo.addAttribute("lista", lista.get());

        return "minhaLista/editar";
    }

    @PostMapping("/editar-lista/{id}")
    public String salvarEdicao(MinhaLista minhaLista, @PathVariable("id") Long id) {
        MinhaLista minhaListaBD = minhaListaServico.encontraUm(id).get();

        for (Produto produto:minhaListaBD.getProdutos()) {

            if(!(minhaLista.getProdutos().contains(produto))) {
                minhaListaServico.deletar(minhaListaBD.getId());
            }

        }
        return "minhaLista/cadastro";
    }

}

