package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
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
        for(int i = 0; i < minhaLista.getProdutos().size(); i++) {
            minhaListaServico.atualizar(id, minhaLista.getProdutos().get(i).getId());
        }

        return "minhaLista/cadastro";
    }

    //Dar continuidade ao metodo para compara o que está no banco com o que está no selecionado no checkbox
    // o que está no parametro é o que retorna do html
    //O que está instanciado(lista) é o que está no banco.
    @PostMapping("/editar-lista/{id}/remover-item")
    public String removerItem(MinhaLista minhaLista, @PathVariable("id") Long id) {
        Optional<MinhaLista> lista = minhaListaServico.encontraUm(id);
        for(int i = 0; i < lista.get().getProdutos().size(); i++) {
            if (minhaLista.getId() != lista.get().getId())
            minhaListaServico.removerItem(id,lista.get().getId());
        }
        return "minhaLista/cadastro";
    }



}

