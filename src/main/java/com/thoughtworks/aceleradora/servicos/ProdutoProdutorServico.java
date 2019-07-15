package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;

    @Autowired
    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
    }

    public List<ProdutoProdutor> pegarProdutos() {
        return produtoProdutorRepositorio.findAll();
    }


    public Map<Produto, List<ProdutoProdutor>> pegaProdutoProdutorPorProdutos(List<Produto> produtos) {
        List<ProdutoProdutor> produtosProdutoresDaLista = produtoProdutorRepositorio.findByProdutoIn(produtos);

        LinkedHashMap<Produto, List<ProdutoProdutor>> produtorPorProduto = produtosProdutoresDaLista
                .stream()
                .collect(Collectors.groupingBy(ProdutoProdutor::getProduto))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Produto::getNome)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        arr -> arr
                                .getValue()
                                .stream()
                                .sorted(Comparator.comparing(produtoProdutor -> produtoProdutor
                                        .getProdutor()
                                        .getNome()))
                                .collect(Collectors.toList()),
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        return produtorPorProduto;
    }

    public ProdutoProdutor encontraUm(Long id) {
        return produtoProdutorRepositorio
                .findById(id)
                .orElseThrow(ProdutoNaoEncontradoExcecao::new);
    }

    public ProdutoProdutor salvar(ProdutoProdutor produtoProdutor) {
        return produtoProdutorRepositorio.save(produtoProdutor);
    }

    public List<ProdutoProdutor> buscaEstoqueDoProdutorPorId(Long id){
        return produtoProdutorRepositorio.findAllById(id);
    }

    public List<ProdutoProdutor> buscarPorNome(String nome){
        return produtoProdutorRepositorio.findAllByProdutorNome(nome);
    }

}