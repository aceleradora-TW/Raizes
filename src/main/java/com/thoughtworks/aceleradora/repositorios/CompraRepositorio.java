package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepositorio extends CrudRepository<Compra, Long> {

    List<Compra> findAll();

    void deleteById(Long id);


}

