package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio repositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public ProdutoProdutor encontraUm(Long id) {
        return repositorio
                .findById(id)
                .orElseThrow(ProdutoNaoEncontradoExcecao::new);

    }

    public ProdutoProdutor salvar(ProdutoProdutor produtoProdutor) {

        if (produtoProdutor.getQuantidadeEstoque() == null || produtoProdutor.getPreco() == null) {
            throw new ProdutoNaoSalvoExcecao();
        }

        return repositorio.save(produtoProdutor);
    }


}