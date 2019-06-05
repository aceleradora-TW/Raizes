package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Resposta;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinhaListaServico {

    private MinhaListaRepositorio repositorio;
    private ClienteServico clienteServico;

    public MinhaListaServico(MinhaListaRepositorio repositorio, ClienteServico clienteServico) {
        this.repositorio = repositorio;
        this.clienteServico = clienteServico;
    }

    public Resposta<MinhaLista> salvar(MinhaLista lista) {
        try {
            Cliente neiva = clienteServico.encontraNeiva();

            lista.setCliente(neiva);

            return new Resposta<>("Registro Efetivado!", repositorio.save(lista));
        } catch (Exception e) {
            return new Resposta(e.getMessage(), null);
        }
    }

    public Resposta<MinhaLista> encontraUm(Long id) {
        try {
            return new Resposta<>(null, repositorio.findById(id).get());
        } catch (Exception e) {
            return new Resposta(e.getMessage(), null);
        }
    }

    public Resposta<List<MinhaLista>> pegarListasCriadas() {
        try {
            return new Resposta<>(null, repositorio.findAll());
        } catch (Exception e) {
            return new Resposta(e.getMessage(), null);
        }
    }

    public Resposta<Boolean> removerListaCriada(Long idLista) {
        try {
            repositorio.deleteById(idLista);
            return new Resposta<>("Registro efetivado!", true);
        } catch (Exception e) {
            return new Resposta(e.getMessage(), false);
        }
    }
}
