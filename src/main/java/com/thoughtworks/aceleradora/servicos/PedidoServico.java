package com.thoughtworks.aceleradora.servicos;
import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Produtor> procurarProdutores(Produto produto) {
        List<Produtor> todosProdutores = produtorServico.pegarTodosProdutores();
        List<Produtor> produtoresDoProduto = new ArrayList<>();

        for (Produtor produtor : todosProdutores) {
            List<Produto> produtosAtual = produtor.getProdutos();

            for (Produto produtoDoProdutor : produtosAtual) {
                if(produtoDoProdutor.equals(produto)) {
                    produtoresDoProduto.add(produtor);
                }
            }
        }

        return produtoresDoProduto;
    }


    public Map<Produto, List<Produtor>> pegarProdutoresDosProdutos(List<Produto> listaDeProdutos){
        Map<Produto, List<Produtor>> mapa = new HashMap<>();

        for (Produto produto: listaDeProdutos) {
            List<Produtor> produtores = procurarProdutores(produto);
            mapa.put(produto, produtores);
        }
        return mapa;
    }


    public Map<Produto,Map<List<Produtor>, ProdutoProdutor>> pegarTodaInformacaoDeProduto(){
        Map<Produto,Map<List<Produtor>, ProdutoProdutor>> mapa = new HashMap<>();
        //1.Fazer getProdutos de produtoProdutor funcionar
        //2.Equivaler o produto de ProdutoProdutor com o produto que eu quero.
        //3.O resultado de todos os preco&qtd do produto, virá uma lista de preco e quantidade daquele produto
        // Ex: recebo Maça e quero achar MAÇA em produtoProdutor
        // acho a maça e pego o preço&qtd dela(que é o produtoProdutor)
        //Adiciono esses valores numa lista de ProdutoProdutor da MAÇA
        //Acho os produtores de MAÇA, procuro com o for cada preco e quantidade
        //de cda produtor e adiciono esse prodprod numa lista final.

        return mapa;

    }

    public Pedido salvar(Pedido pedido) {
        return repositorio.save(pedido);
    }



}
