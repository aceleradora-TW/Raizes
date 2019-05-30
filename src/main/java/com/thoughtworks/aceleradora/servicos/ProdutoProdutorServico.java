package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio repositorio;
    private ProdutorRepositorio produtorRepositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio,
                                  ProdutorRepositorio produtorRepositorio) {
        this.repositorio = repositorio;
        this.produtorRepositorio = produtorRepositorio;
    }

    private List<ProdutoProdutor> pegaProdutores(Produto produto) {
        List<ProdutoProdutor> produtoProdutores = repositorio.findAll();
        List<Produtor> produtores = produtorRepositorio.findAll();

//        for (Produto : repositorio.findAll()) {
//            Produtor produtorEncontrado = produto
//        }
        return null;
    }
}
