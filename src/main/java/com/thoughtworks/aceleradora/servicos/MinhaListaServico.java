package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MinhaListaServico {

    private MinhaListaRepositorio repositorio;
    private ClienteServico clienteServico;

    public MinhaListaServico(MinhaListaRepositorio repositorio, ClienteServico clienteServico) {
        this.repositorio = repositorio;
        this.clienteServico = clienteServico;
    }

    public MinhaLista salvar(MinhaLista lista) {
        lista.setCliente(clienteServico.encontraCliente());
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

    public List<MinhaLista> pegarListasCriadasPorId(Long id) {
        return repositorio.findAllByClienteId(id);
    }

    public void removerListaCriada(Long idLista) {
         repositorio.deleteById(idLista);
    }

    public Optional<MinhaLista> findByNome(String nome) {
        return repositorio.findByNome(nome);
    }
    public List<MinhaLista> buscarPorNome(String nome) {
        return repositorio.findAllByNome(nome);
    }

}
