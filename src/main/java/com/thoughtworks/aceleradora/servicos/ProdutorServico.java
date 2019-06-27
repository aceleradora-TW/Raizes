package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutorNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutorServico {

    private ProdutorRepositorio repositorio;

    public ProdutorServico(ProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produtor> pegarTodosProdutores() {
        return repositorio.findAll();
    }

    public Produtor encontraUm(Long id){
        return repositorio
                .findById(id)
                .orElseThrow(ProdutorNaoEncontradoExcecao::new);
    }

}
