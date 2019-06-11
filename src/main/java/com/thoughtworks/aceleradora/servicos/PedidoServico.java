package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.List;

@Service
public class PedidoServico {

    private PedidoRepositorio repositorio;

    public PedidoServico(PedidoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Pedido encontraUm(Long id) {
        Pedido pedidos = repositorio.findById(id).get();

        return pedidos;
    }

    public List<Pedido> ordenaPedido(List<Pedido> pedidos){
        List<Pedido> pedidosOrdenadas;

//        for (pedido: pedidos) {
//
//        }

        return null;
    }
}
