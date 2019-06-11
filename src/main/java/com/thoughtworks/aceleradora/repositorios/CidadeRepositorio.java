package com.thoughtworks.aceleradora.repositorios;
import com.thoughtworks.aceleradora.dominio.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepositorio extends CrudRepository<Cidade, Long> {

}
