package com.thoughtworks.aceleradora.servicos;


import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> pegarTodosPorOrdemAlfabetica() {
            return repositorio.findAllByOrderByNome();
    }

    public Produto salvar (Produto produto) {
        return repositorio.save(produto);
    }

    public Produto encontraUm(Long id) {
        return repositorio.findById(id).get();
    }

    public Optional<Produto> encontraUmNome(String nome) { return repositorio.findByNome(nome); }

    public String encontraUnidadeMedida (Long id){
        return repositorio.findById(id).get().getUnidadeMedida().getCodigo();
    }
}