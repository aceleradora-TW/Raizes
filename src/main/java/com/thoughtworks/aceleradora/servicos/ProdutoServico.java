package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> getAll() {
        return repositorio.findAll();
    }
}
