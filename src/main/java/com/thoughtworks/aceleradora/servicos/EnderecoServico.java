package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Endereco;
import com.thoughtworks.aceleradora.repositorios.EnderecoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServico {
    private EnderecoRepositorio repositorio;

    public EnderecoServico(EnderecoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Endereco> pegaTodos() {
        return repositorio.findAll();
    }
}
