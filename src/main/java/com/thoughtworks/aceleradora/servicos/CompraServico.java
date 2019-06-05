package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Compra;
import com.thoughtworks.aceleradora.repositorios.CompraRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServico {
   private CompraRepositorio repositorio;


    public CompraServico(CompraRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public List<Compra> pegarCompras() {
        return repositorio.findAll();
    }

    public Compra encontraUm(Long id) {
        try {
            Compra compra = repositorio.findById(id).get();
            return compra;

        } catch (Exception e) {
            return null;
        }
    }

    public void removerCompra(Long idCompra) {
        repositorio.deleteById(idCompra);
    }

}
