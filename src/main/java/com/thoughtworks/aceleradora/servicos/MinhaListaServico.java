package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Resposta;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
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

    public MinhaLista salvar(MinhaLista lista) {
        lista.setCliente(clienteServico.encontraNeiva());
        return repositorio.save(lista);
    }

    public MinhaLista encontraUm(Long id) {
        return repositorio
                .findById(id)
                .orElseThrow(ListaNaoEncontradaExcecao::new);
    }

    public List<MinhaLista> pegarListasCriadas() {
        return repositorio.findAll();
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
