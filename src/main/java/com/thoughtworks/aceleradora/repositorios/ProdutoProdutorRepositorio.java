package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoProdutorRepositorio extends CrudRepository<ProdutoProdutor, Long> {
        List<ProdutoProdutor> findAll();


}
