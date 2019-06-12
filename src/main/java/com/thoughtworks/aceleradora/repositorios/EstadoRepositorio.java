package com.thoughtworks.aceleradora.repositorios;
import com.thoughtworks.aceleradora.dominio.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoRepositorio extends CrudRepository<Estado, Long> {

}
