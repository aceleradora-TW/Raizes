package com.thoughtworks.aceleradora.servicos;


import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> pegarTodosPorOrdemAlfabetica() {
        return repositorio.findAllByOrderByNome();
    }

    public Produto salvar(Produto produto) {
        return repositorio.save(produto);
    }
    public  List<ProdutoProdutor> pegarEstoqueDoProdutorPorId(Long id){
        return repositorio.findAllByProdutor_Id(id);
    }

}