package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.dominio.excecoes.ClienteNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;
    private ProdutorServico produtorServico;

    @Autowired
    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio, ProdutorServico produtorServico) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
        this.produtorServico = produtorServico;
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
        produtoProdutor.setProdutor(produtorServico.encontraProdutor());

        return produtoProdutorRepositorio.save(produtoProdutor);
    }

    public List<ProdutoProdutor> buscarPorEmail(String email) {
        return produtoProdutorRepositorio.findAllByProdutorEmail(email);
    }

    public boolean hasProdutor(Map<Produto, List<ProdutoProdutor>> produtoresDeProdutos) {

        if(produtoresDeProdutos == null || produtoresDeProdutos.isEmpty()) return false;

        return produtoresDeProdutos.values()
                .stream()
                .findFirst()
                .get()
                .stream()
                .anyMatch(produtoProdutor -> produtoProdutor.getProdutor() != null);
    }
}