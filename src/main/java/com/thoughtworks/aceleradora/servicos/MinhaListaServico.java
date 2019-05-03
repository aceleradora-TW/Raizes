package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class MinhaListaServico {

    private MinhaListaRepositorio repositorio;

    public MinhaListaServico(MinhaListaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public MinhaLista  salvar(MinhaLista lista) {
        return repositorio.save(lista);
    }

}
