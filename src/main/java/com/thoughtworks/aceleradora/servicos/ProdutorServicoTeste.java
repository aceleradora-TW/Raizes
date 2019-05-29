package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorioTeste;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutorServicoTeste {

    private ProdutorRepositorioTeste repositorio;

    public ProdutorServicoTeste(ProdutorRepositorioTeste repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produtor> pegarTodosProdutores() { return repositorio.findAll();}


}
