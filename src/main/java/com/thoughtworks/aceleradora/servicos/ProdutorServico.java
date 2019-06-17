package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ProdutorServico {
    private ProdutorRepositorio repositorio;

    public ProdutorServico(ProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

}
