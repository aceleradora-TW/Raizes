package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {

    List<Produto> findAllByOrderByNome();
    Optional<Produto> findById(Long id);

    Optional<Produto> findByNome(String nome);
    List<ProdutoProdutor> findAllByProdutor_Id(Long id);


}
