package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {

    List<Produto> findAll();

}
