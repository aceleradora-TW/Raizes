package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.PedidoProdutoProdutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoProdutoProdutorRepositorio {
    Optional<PedidoProdutoProdutor> findById(Long id);
}
