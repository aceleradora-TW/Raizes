package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    List<Usuario> findAll();
    Optional<Usuario> findById(Long Id);
}
