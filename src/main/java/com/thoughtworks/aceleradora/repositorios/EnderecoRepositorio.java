package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepositorio extends CrudRepository<Endereco, Long> {
    List<Endereco> findAll();
}

