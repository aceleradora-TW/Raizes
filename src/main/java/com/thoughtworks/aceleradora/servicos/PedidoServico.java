package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class PedidoServico {
    PedidoRepositorio repositorio;

    public Pedido salvar(Pedido pedido) {
            return repositorio.save(pedido);
        }
    public Pedido encontraUm(Long id) {
        Pedido pedido = repositorio.findById(id).get();
        return pedido;

    }
}