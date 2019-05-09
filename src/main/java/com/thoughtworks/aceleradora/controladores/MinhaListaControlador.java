package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dtos.ProdutoDTO;
import com.thoughtworks.aceleradora.servicos.MinhaListaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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


//    MinhaLista lista =

    @GetMapping("/cadastro")
    public String renderizaProdutos(Model modelo, HttpSession sessao) {
        List<Produto> produtos = produtoServico.pegarTodos();
        MinhaLista lista = (MinhaLista) sessao.getAttribute("minhaLista");
        if(lista != null ){
            List<ProdutoDTO> listaChecada = checadoTrue(produtos, lista.getProdutos());
            modelo.addAttribute("produtos", listaChecada);
            modelo.addAttribute("nomelista",lista.getNome());
        } else {
            modelo.addAttribute("produtos", produtos);
        }

        return "minhaLista/cadastro";
    }

    @PostMapping("/cadastro/previa")
    public String previaLista(MinhaLista lista, Model modelo, HttpSession sessao) {
        modelo.addAttribute("minhaLista", lista);
        sessao.setAttribute("minhaLista", lista);
        return "minhaLista/previa";
    }

    @PostMapping("/cadastro")
    public String salvarLista(HttpSession sessao) {
        MinhaLista lista = (MinhaLista) sessao.getAttribute("minhaLista");
        MinhaLista novaLista = minhaListaServico.salvar(lista);
        return "minhaLista/cadastro";
    }

    private List<ProdutoDTO> checadoTrue(List<Produto> todosProdutos, List<Produto> produtosChecados){

        List<ProdutoDTO> listaChecada = todosProdutos
                .stream()
                .map(produto -> new ProdutoDTO(produto.getNome(), true)).collect(Collectors.toList());


        return listaChecada;
    }
}

