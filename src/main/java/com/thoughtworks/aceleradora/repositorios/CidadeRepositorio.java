package com.thoughtworks.aceleradora.repositorios;
import com.thoughtworks.aceleradora.dominio.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CidadeRepositorio extends CrudRepository<Cidade, Long> {
    List<Cidade> findAll();
}
