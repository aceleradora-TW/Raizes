package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoProdutorRepositorio extends CrudRepository<ProdutoProdutor, Long> {


}