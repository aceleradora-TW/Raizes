package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.classeDTO.ListaProdutoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaProdutoDTORepositorio extends CrudRepository<ListaProdutoDTO, Long> {
    Optional<ListaProdutoDTO> findById(Long id);

    @Override
    void deleteById(Long aLong);

}
