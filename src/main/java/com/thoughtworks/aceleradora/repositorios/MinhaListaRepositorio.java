package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Optional;

@Repository
public interface MinhaListaRepositorio extends CrudRepository<MinhaLista, Long> {
    Optional<MinhaLista> findByNome(String nome);
    List<MinhaLista> findAll();
    Optional<MinhaLista> findById(Long id);

    void deleteById(Long id);
}
