package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @PostMapping("/editar-lista/{id}/remover-item")
    public String removerItem(MinhaLista ListaDoFronte, @PathVariable("id") Long id) {
        Optional<MinhaLista> ListaDoBanco = minhaListaServico.encontraUm(id);
        List<Produto> produtosParaSeremRemovidos = new ArrayList<>();

        if (ListaDoBanco.isPresent()) {
            List<Produto> ProdutosDoBanco = ListaDoBanco.get().getProdutos();
            List<Produto> produtosFront = ListaDoFronte.getProdutos();

            for(Produto produtoDoBanco : ProdutosDoBanco) {
                if (!produtosFront.contains(produtoDoBanco)) {
                    produtosParaSeremRemovidos.add(produtoDoBanco);
                }
            }

            ListaDoBanco.get().getProdutos().removeAll(produtosParaSeremRemovidos);

            minhaListaServico.salvar(ListaDoBanco.get());
        }
        return "minhaLista/cadastro";
    }
}

