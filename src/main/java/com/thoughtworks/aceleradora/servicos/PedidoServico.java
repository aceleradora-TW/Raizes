package com.thoughtworks.aceleradora.servicos;
import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServico {
    private PedidoRepositorio repositorio;

    public PedidoServico(PedidoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produtor> pegaProdutoresDosProdutos(MinhaLista minhaLista) {
        //1. percorrer a lista
        //2. pegar todos os produtores de um produto
        //3. armazenar produtores em nova lista
        //4. retornar lista de produtores encontrados

        for (Produto produto : minhaLista.getProdutos()) {

        }

        return null;
    }

}
