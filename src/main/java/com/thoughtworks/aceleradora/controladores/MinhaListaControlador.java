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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String criarLista(Model modelo) {

        modelo.addAttribute("lista", new MinhaLista());

        List<Categoria> categorias = categoriaServico.pegarCategorias();
        modelo.addAttribute("categorias", categorias);

        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarLista(MinhaLista lista, Model modelo) {

        Optional<MinhaLista> listaComMesmoNome = minhaListaServico.findByNome(lista.getNome());

        modelo.addAttribute("lista", lista);

        if (listaComMesmoNome.isPresent()) {

            List<Categoria> categorias = categoriaServico.pegarCategorias();
            modelo.addAttribute("categorias", categorias);

            return "minhaLista/cadastro";

        } else {
            minhaListaServico.salvar(lista);
            return "minhaLista/cadastro";
        }
    }

    @ResponseBody
    @GetMapping("/pegarCategorias")
    public List<Categoria> salvarLista() {
        return categoriaServico.pegarCategorias();
    }

}
