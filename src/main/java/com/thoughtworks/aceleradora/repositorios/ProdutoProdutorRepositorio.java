package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoProdutorRepositorio extends CrudRepository<ProdutoProdutor, Long> {
        List<ProdutoProdutor> findByProdutoIn(List<Produto> produtos);
        Optional<ProdutoProdutor> findById(Long id);


}
