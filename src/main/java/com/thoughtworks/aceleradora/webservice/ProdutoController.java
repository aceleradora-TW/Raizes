package com.thoughtworks.aceleradora.webservice;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ws")
public class ProdutoController {
    private ProdutoServico produtoServico;

    public ProdutoController(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }
    @ResponseBody
    @GetMapping("/produtos")
    List<Produto> pegarTodosOsProdutos() {
        return  produtoServico.pegarTodosPorOrdemAlfabetica();
    }
}
