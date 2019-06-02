package com.thoughtworks.aceleradora.servicos;


import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;
    private MinhaListaServico minhaListaServico;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> pegarTodos() {
        return repositorio.findAll();
    }

    public Produto salvar(Produto produto) {
        return repositorio.save(produto);
    }

    public Optional<Produto> encontraUm(Long id) {
        return repositorio.findById(id);
    }


}