package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.Produtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoProdutorRepositorio extends CrudRepository<ProdutoProdutor, Long> {

    Optional<ProdutoProdutor> findById(Long id);
    List<ProdutoProdutor> findByProdutoIn(List<Produto> produtos);
    List<ProdutoProdutor> findAll();
    List<ProdutoProdutor> findByProdutorIn(List<Produtor> produtores);

}
