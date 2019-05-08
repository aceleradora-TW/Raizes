package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.repositorios.CategoriaRepositorio;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/minha-lista")
public class MinhaListaControlador {

    private ProdutoServico produtoServico;
    private MinhaListaServico minhaListaServico;
    private CategoriaServico categoriaServico;

    @Autowired
    public MinhaListaControlador(ProdutoServico produtoServico, MinhaListaServico minhaListaServico, CategoriaServico categoriaServico) {
        this.produtoServico = produtoServico;
        this.minhaListaServico = minhaListaServico;
        this.categoriaServico = categoriaServico;
    }


    @GetMapping("/cadastro")
    public String criarLista(Model model) {

        List<Categoria> categorias = categoriaServico.pegarCategorias();

        System.out.println(categorias.get(0).getProdutos());

        model.addAttribute("produtos", produtoServico.pegarTodos());


        model.addAttribute("categorias", categorias);

        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista) {

        minhaListaServico.salvar(lista);
        return "minhaLista/cadastro";
    }

}

