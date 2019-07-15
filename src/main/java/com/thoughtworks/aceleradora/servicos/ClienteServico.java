package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.dominio.excecoes.ClienteNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    private ClienteRepositorio repositorio;
    private UserDetailsImpl usuarioServico;

    public ClienteServico(ClienteRepositorio repositorio, UserDetailsImpl usuarioServico) {
        this.repositorio = repositorio;
        this.usuarioServico = usuarioServico;
    }

    public Cliente encontraCliente() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Usuario usuario = usuarioServico.buscaUmUsuario(auth.getName());

        return repositorio
                .findById(usuario.getId())
                .orElseThrow(ClienteNaoEncontradoExcecao::new);
    }
}
