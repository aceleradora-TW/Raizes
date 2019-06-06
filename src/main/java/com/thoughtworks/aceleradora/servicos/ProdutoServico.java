package com.thoughtworks.aceleradora.servicos;


import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Resposta;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Resposta<List<Produto>> pegarTodos() {
        try {
            return new Resposta<List<Produto>>(null, repositorio.findAll());
        }catch (Exception e) {
            return new Resposta(e.getMessage(),null);
        }
    }

    public Resposta<Produto> salvar(Produto produto) {
        try {
            return new Resposta<Produto>("Registro Efetivado!", repositorio.save(produto));
        }catch (Exception e) {
            return new Resposta(e.getMessage(),null);
        }
    }

    public Resposta<Produto> encontraUm(Long id) {
        try {
            return new Resposta<Produto>(null, repositorio.findById(id).get());
        } catch (Exception e) {
            return new Resposta(e.getMessage(),null);
        }
    }




}