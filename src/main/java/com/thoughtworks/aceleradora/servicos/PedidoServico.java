package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServico {

    private PedidoRepositorio repositorio;


    public PedidoServico(PedidoRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public List<Pedido> pegarPedidos() {
        return repositorio.findAll();
    }

    public Pedido encontraUm(Long id) {
        Pedido pedidos = repositorio.findById(id).get();

        return pedidos;
    }

    public void removerPedido(Long idCompra) {
        repositorio.deleteById(idCompra);
    }

}
