package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface PedidoRepositorio extends CrudRepository<Pedido, Long> {
        List<Pedido> findAll();
    Optional<Pedido> findById(Long id);

    }
