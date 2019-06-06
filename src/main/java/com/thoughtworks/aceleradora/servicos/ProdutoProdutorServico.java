package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.TipoDeCultivo;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProdutoProdutorServico {
    private ProdutoProdutorRepositorio repositorio;

    public ProdutoProdutorServico(ProdutoProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<TipoDeCultivo> pegaTiposDeCultivos(){
        List<TipoDeCultivo> cultivos = Arrays.asList(TipoDeCultivo.values());
        return cultivos;
    }
}
