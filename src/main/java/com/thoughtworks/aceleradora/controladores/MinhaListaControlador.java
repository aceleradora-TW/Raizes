package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.classeDTO.ListaProdutoDTO;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.ListaProdutoDTORepositorio;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @PostMapping("/editar-lista/{id}/remover-item")
    public String removerItem(MinhaLista ListaDoFronte, @PathVariable("id") Long id) {
        Optional<MinhaLista> listaDoBanco = minhaListaServico.encontraUm(id);
        List<Produto> devoDeletar = new ArrayList<>();
                listaDoBanco.get().getProdutos().stream()
                .forEach(produto -> {
                    if(!ListaDoFronte.getProdutos().stream().anyMatch(k-> k.getId() == produto.getId())){
                        devoDeletar.add(produto);
                    }
                });
        return "/editar-listaDoBanco/{id}";
    }



}

