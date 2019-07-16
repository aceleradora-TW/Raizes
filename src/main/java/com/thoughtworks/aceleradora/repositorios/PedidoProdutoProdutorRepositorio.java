package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.PedidoProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoProdutoProdutorRepositorio {
    Optional<PedidoProdutoProdutor> findById(Long id);

}
