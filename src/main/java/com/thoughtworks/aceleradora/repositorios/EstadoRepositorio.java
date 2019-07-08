package com.thoughtworks.aceleradora.repositorios;
import com.thoughtworks.aceleradora.dominio.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstadoRepositorio extends CrudRepository<Estado, Long> {
    List<Estado> findAll();
}
