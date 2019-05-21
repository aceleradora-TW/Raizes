package com.thoughtworks.aceleradora.login.servicos;

import com.thoughtworks.aceleradora.login.dominio.Usuario;
import com.thoughtworks.aceleradora.login.dominio.UsuarioRepositorio;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Service
public class UserDetailsImpl implements UserDetailsService {

    private UsuarioRepositorio usuarioRepositorio;

    public UserDetailsImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByNome(username);

        Set<GrantedAuthority> permissoes = Stream
                .of(new SimpleGrantedAuthority(usuario.getTipousuario().getNome()))
                .collect(toSet());

        return new User(usuario.getNome(), usuario.getSenha(), permissoes);
    }
}
