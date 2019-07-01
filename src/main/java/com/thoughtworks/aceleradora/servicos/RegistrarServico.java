package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    private ClienteRepositorio clienteRepositorio;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioServico(ClienteRepositorio clienteRepositorio, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void salvarCliente(Cliente cliente) {
        cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
        .save(cliente);
    }


}
