package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutorNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutorServico {
    private ProdutorRepositorio repositorio;

    @Autowired
    public ProdutorServico(ProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Produtor encontraUm(Long id){
        return repositorio
                .findById(id)
                .orElseThrow(ProdutorNaoEncontradoExcecao::new);
    }
}
