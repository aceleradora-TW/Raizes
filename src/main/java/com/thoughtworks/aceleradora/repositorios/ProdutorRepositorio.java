package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutorRepositorio extends CrudRepository<Produtor, Long> {
    List<Produtor> findAll();
    Optional<Produtor> findById(Long id);
    Produtor findByEmail(String email);
}

