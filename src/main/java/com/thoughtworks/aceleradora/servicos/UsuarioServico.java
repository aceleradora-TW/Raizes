package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    private UsuarioRepositorio usuarioRepositorio;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioServico(UsuarioRepositorio usuarioRepositorio, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void salvar(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepositorio.save(usuario);
    }
}
