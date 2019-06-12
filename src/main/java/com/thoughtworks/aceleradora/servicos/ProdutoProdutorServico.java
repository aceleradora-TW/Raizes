package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio produtoProdutorRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio produtoProdutorRepositorio) {
        this.produtoProdutorRepositorio = produtoProdutorRepositorio;
    }
}
