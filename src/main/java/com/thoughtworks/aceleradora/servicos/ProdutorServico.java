package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutorServico {

    private ProdutorRepositorio repositorio;

    public ProdutorServico (ProdutorRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public Produtor encontraUm(Long id) {
        Produtor produtor = repositorio.findById(id).get();

        return produtor;
    }


    public List<Produtor> pegarTodos() {
        return repositorio.findAll();
    }
}
