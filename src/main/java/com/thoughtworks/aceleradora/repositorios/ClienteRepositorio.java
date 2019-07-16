package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

    List<Cliente> findAll();
    Optional<Cliente> findById(Long Id);

}
