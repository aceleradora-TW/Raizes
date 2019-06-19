package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    private ClienteRepositorio repositorio;

    public ClienteServico(ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Cliente encontraCliente() {
        return repositorio
                .findByNome("Cliente")
                .orElseThrow(() -> new IllegalStateException("Cliente não está cadastrado"));
    }

    public void salvaCliente(Cliente cliente) {
        repositorio.save(cliente);
    }

    public Cliente buscaPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }
}
