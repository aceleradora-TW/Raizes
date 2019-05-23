package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cultivo;
import com.thoughtworks.aceleradora.repositorios.CultivoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultivoServico {
    CultivoRepositorio repositorio;

    public CultivoServico(CultivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Cultivo> pegarCultivos() {
        return repositorio.findAll();
    }

}
