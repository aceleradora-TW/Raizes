package com.thoughtworks.aceleradora.repositorios;
import com.thoughtworks.aceleradora.dominio.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends CrudRepository<Pedido, Long> {

}
