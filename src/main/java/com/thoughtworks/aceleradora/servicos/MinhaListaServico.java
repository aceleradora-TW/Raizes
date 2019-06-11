package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Resposta;
import com.thoughtworks.aceleradora.dominio.excecoes.ListaNaoEncontradaExcecao;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Produto> pegaProdutosParaSeremRemovidos(List<Produto> produtosFront, List<Produto> produtosDoBanco) {
        List<Produto> produtosParaSeremRemovidos = new ArrayList<>();

        for (Produto produto : produtosDoBanco) {
            if (!produtosFront.contains(produto)) {
                produtosParaSeremRemovidos.add(produto);
            }
        }

        return produtosParaSeremRemovidos;
    }
    public Optional<MinhaLista> findByNome(String nome) {
        return repositorio.findByNome(nome);
    }

}
