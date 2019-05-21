package com.thoughtworks.aceleradora.login.servicos;

import com.thoughtworks.aceleradora.login.dominio.Usuario;
import com.thoughtworks.aceleradora.login.dominio.UsuarioRepositorio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
    private UsuarioRepositorio usuarioRepositorio;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioServico(UsuarioRepositorio usuarioRepositorio, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void salvar(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepositorio.save(usuario);
    }
}
