package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio repositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public String pegaTipoDeProduto(Long id){
       return repositorio.findById(id).get().getTipoDeCultivo().getCodigo();
    }

    public Optional<ProdutoProdutor> encontraUm(Long id){
        return repositorio.findById(id);
    }
}