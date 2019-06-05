package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.repositorios.CategoriaRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServico {

    private CategoriaRepositorio repositorio;

    public CategoriaServico(CategoriaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Categoria> pegarCategorias() {
        return repositorio.findAll();
    }
}
