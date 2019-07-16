package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.Estado;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.dominio.excecoes.EstadoNaoEncontradoExcecao;
import com.thoughtworks.aceleradora.repositorios.ClienteRepositorio;
import com.thoughtworks.aceleradora.repositorios.EstadoRepositorio;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrarServico {

    private ClienteRepositorio clienteRepositorio;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ProdutorRepositorio produtorRepositorio;
    private EstadoRepositorio estadoRepositorio;

    @Autowired
    public RegistrarServico(ClienteRepositorio clienteRepositorio, BCryptPasswordEncoder bCryptPasswordEncoder, ProdutorRepositorio produtorRepositorio, EstadoRepositorio estadoRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.produtorRepositorio = produtorRepositorio;
        this.estadoRepositorio = estadoRepositorio;
    }

    public void salvarCliente(Cliente cliente) {
        cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
        clienteRepositorio.save(cliente);
    }

    public void salvarProdutor(Produtor produtor) {
        produtor.setSenha(bCryptPasswordEncoder.encode(produtor.getSenha()));
        produtorRepositorio.save(produtor);
    }

    public Estado pegarRS() {
            return estadoRepositorio.findById(1L)
                    .orElseThrow(EstadoNaoEncontradoExcecao::new);
        }
    }


