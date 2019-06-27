package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void salvar(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuarioRepositorio.save(usuario);
    }
}
