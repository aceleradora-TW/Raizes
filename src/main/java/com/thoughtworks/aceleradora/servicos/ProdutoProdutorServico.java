package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
    }

    public List<ProdutoresDeProdutos> organizarProdutoresDeProdutos(List<ProdutoProdutor> produtoProdutores) {
        Map<Produto, ProdutoresDeProdutos> mapaDeProdutoresDeProdutos = new HashMap<>();
        for (ProdutoProdutor produtoProdutor : produtoProdutores) {
            Produto produto = produtoProdutor.getProduto();
            Produtor produtor = produtoProdutor.getProdutor();
            if(mapaDeProdutoresDeProdutos.containsKey(produto)) {
                ProdutoresDeProdutos produtoresDeProdutos = mapaDeProdutoresDeProdutos.get(produto);
                produtoresDeProdutos.adicionaProdutor(produtor);
            } else {
                ProdutoresDeProdutos produtorDeProduto =
                        new ProdutoresDeProdutos(produto, produtor);

                mapaDeProdutoresDeProdutos.put(produto, produtorDeProduto);
            }
        }
        return new ArrayList<>(mapaDeProdutoresDeProdutos.values());
    }


}
