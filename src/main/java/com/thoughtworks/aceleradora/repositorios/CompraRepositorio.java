package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Compras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepositorio extends CrudRepository<Compras, Long> {

    List<Compras> findAll();

    void deleteById(Long id);


}

