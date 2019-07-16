package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
        Usuario findByEmail(String email);
        Optional<Usuario> findById(Long id);
}

