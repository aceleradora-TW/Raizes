package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutorNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutorServico {

    private UserDetailsImpl usuarioServico;
    private ProdutorRepositorio repositorio;

    public ProdutorServico(ProdutorRepositorio repositorio, UserDetailsImpl usuarioServico) {
        this.repositorio = repositorio;
        this.usuarioServico = usuarioServico;
    }

    public List<Produtor> pegarTodosProdutores() {
        return repositorio.findAll();
    }

    public Produtor encontraUm(Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Usuario usuario = usuarioServico. buscaUmUsuario(auth.getName());

        return repositorio
                .findById(usuario.getId())
                .orElseThrow(ProdutorNaoEncontradoExcecao::new);
    }

    public Produtor encontraProdutorPorEmail(String email) {
        return repositorio.findByEmail(email);
    }

    public Produtor encontraProdutor(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioServico.buscaUmUsuario(auth.getName());
        return repositorio
                .findById(usuario.getId())
                .orElseThrow(ProdutorNaoEncontradoExcecao::new);
    }
}
