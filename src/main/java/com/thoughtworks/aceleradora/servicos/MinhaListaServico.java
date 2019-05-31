package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MinhaListaServico {

    private MinhaListaRepositorio repositorio;

    public MinhaListaServico(MinhaListaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public MinhaLista salvar(MinhaLista lista) {
        try {
            return repositorio.save(lista);
        } catch(Exception e) {
            return null;
        }
    }

    public MinhaLista encontraUm(Long id) {
        try {
            MinhaLista minhaLista = repositorio.findById(id).get();
            return minhaLista;

        } catch (Exception e) {
            return null;
        }
    }

    public List<MinhaLista> pegarListasCriadas() {
        return repositorio.findAll();
    }

    public void removerListaCriada(Long idLista) {
        repositorio.deleteById(idLista);
    }


    public Optional<MinhaLista> findByNome(String nome) {
        return repositorio.findByNome(nome);
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
}
