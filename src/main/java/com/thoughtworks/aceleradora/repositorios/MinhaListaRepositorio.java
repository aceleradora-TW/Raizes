package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MinhaListaRepositorio extends CrudRepository<MinhaLista, Long> {
    List<MinhaLista> findAll();
}

