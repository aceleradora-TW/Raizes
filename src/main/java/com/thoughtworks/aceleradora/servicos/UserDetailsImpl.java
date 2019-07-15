package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.UsuarioRepositorio;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Collections.emptySet;

@Service
public class UserDetailsImpl implements UserDetailsService {

    private UsuarioRepositorio usuarioRepositorio;

    public UserDetailsImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByEmail(email);

        return new User(usuario.getEmail(), usuario.getSenha(), emptySet());
    }

    public Usuario buscaUmUsuario(String email){
        return usuarioRepositorio.findByEmail(email);
    }
    public Usuario buscaUmUsuarioPorNome(String nome){
        return usuarioRepositorio.findByNome(nome);
    }
    public Optional<Usuario> buscaUmUsuarioPorId(Long id){
        return usuarioRepositorio.findById(id);
    }

}
