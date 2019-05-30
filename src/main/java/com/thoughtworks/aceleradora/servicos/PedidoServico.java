package com.thoughtworks.aceleradora.servicos;
import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServico {
    private PedidoRepositorio repositorio;
    private ProdutoServico produtoServico;
    private ProdutorServico produtorServico;


    public PedidoServico(PedidoRepositorio repositorio,
                         ProdutoServico produtoServico,
                         ProdutorServico produtorServico) {
        this.repositorio = repositorio;
        this.produtoServico = produtoServico;
        this.produtorServico = produtorServico;
    }

    public List<Produto> pegarListaDeProdutosDosProdutores () {
        List<Produtor> produtores = produtorServico.pegarTodosProdutores();
        List<Produto> produtos = new ArrayList<>();

        for (Produtor produtor : produtores) {
            List<Produto> produtosAtual = produtor.getProdutos();

            for (Produto produto : produtosAtual) {
                produtos.add(produto);
            }

        }

        return produtos;

    }

    public List<Produtor> procurarProdutores() {
        List<Produtor> produtores = produtorServico.pegarTodosProdutores();
        Optional<Produto> produtoOptional = produtoServico.encontraUm(4L);
        Produto produtoBeterraba = produtoOptional.get();

        List<Produto> produtos = new ArrayList<>();
        List<Produtor> produtoresDeBeterraba = new ArrayList<>();

        for (Produtor produtor : produtores) {
            List<Produto> produtosAtual = produtor.getProdutos();

            for (Produto produto : produtosAtual) {
                if(produto.equals(produtoBeterraba)) {
                    produtoresDeBeterraba.add(produtor);
                }

            }
        }

        return produtoresDeBeterraba;
    }

//    public List<ProdutoProdutor> pegarProdutoresDosProdutos(MinhaLista minhaLista) {
//        //1. percorrer a lista
//        //2. pegar todos os produtores de um produto
//        //3. armazenar produtores em nova lista
//        //4. retornar lista de produtores encontrados
//
//        List<ProdutoProdutor> listaDeProdutoresPorProdutos = new ArrayList<>();
//
//        for (Produto produto : minhaLista.getProdutos()) {
//            listaDeProdutoresPorProdutos = produtoProdutorServico.pegaProdutores(produto);
//
//        }
//
//        return listaDeProdutoresPorProdutos;
//    }

}
