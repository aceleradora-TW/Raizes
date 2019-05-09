package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorioJdbc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;
    private ProdutoRepositorioJdbc repositorioJdbc;

    public ProdutoServico(ProdutoRepositorio repositorio, ProdutoRepositorioJdbc repositorioJdbc) {
        this.repositorio = repositorio;
        this.repositorioJdbc = repositorioJdbc;
    }

    public List<Produto> pegarTodos() {
        return repositorioJdbc.buscarTodos();
    }
}
