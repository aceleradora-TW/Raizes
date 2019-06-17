package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {

    List<Produto> findAll();
    Optional<Produto> findById(Long id);

    Optional<Produto> findByNome(String nome);


}
