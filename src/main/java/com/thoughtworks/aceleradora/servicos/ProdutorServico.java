package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.repositorios.ProdutorRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ProdutorServico {
    private ProdutorRepositorio repositorio;

    public ProdutorServico(ProdutorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Produtor salvaProdutor(Produtor produtor) {
        return repositorio.save(produtor);
    }

    public Produtor buscaPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

}
