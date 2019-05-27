package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Cultivo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CultivoRepositorio extends CrudRepository<Cultivo, Long> {
    List<Cultivo> findAll();

}
