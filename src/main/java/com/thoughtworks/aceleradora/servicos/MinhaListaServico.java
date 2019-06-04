package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Resposta;
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

    public Resposta<MinhaLista> salvar(MinhaLista lista) {
        try {
            return new Resposta<MinhaLista>("Registro Efetivado!",repositorio.save(lista));
        } catch(Exception e) {
            return new Resposta(e.getMessage(),null);
        }
    }

    public Resposta<MinhaLista> encontraUm(Long id) {
        try {
             return new Resposta<MinhaLista>(null, repositorio.findById(id).get());
        } catch (Exception e) {
            return new Resposta(e.getMessage(),null);
        }
    }

    public Resposta<List<MinhaLista>> pegarListasCriadas() {
        try {
            return new Resposta<List<MinhaLista>>(null, repositorio.findAll());
        } catch (Exception e) {
            return new Resposta(e.getMessage(),null);
        }
    }
    public Resposta<Boolean> removerListaCriada(Long idLista) {
        try {
            repositorio.deleteById(idLista);
            return new Resposta<Boolean>("Registro efetivado!", true);
        } catch (Exception e) {
            return new Resposta(e.getMessage(),false);
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
