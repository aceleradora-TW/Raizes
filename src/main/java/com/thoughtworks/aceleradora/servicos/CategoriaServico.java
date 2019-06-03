package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Categoria;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dtos.CategoriaDTO;
import com.thoughtworks.aceleradora.dtos.ProdutoDTO;
import com.thoughtworks.aceleradora.repositorios.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServico {

    private CategoriaRepositorio repositorio;

    public CategoriaServico(CategoriaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Categoria> pegarCategorias() {
        return repositorio.findAll();
    }

    public List<CategoriaDTO> pegarCategoriasDto() {
        return this.pegarCategorias()
                .stream()
                .map(categoria -> categoria.paraDTO())
                .collect(Collectors.toList());
    }

    public List<CategoriaDTO> setaChecados(List<CategoriaDTO> categorias, List<Produto> produtos) {
        categorias.stream()
                .forEach(cat -> cat.getProdutos().stream()
                        .forEach(produtoDTO -> produtoDTO.setChecado(verificaSeEhChecado(produtoDTO, produtos))));

        return  categorias;
    }

    private boolean verificaSeEhChecado(ProdutoDTO produtoDTO, List<Produto> produtos) {
        return produtos.stream()
                .anyMatch(p -> p.getId().equals(produtoDTO.getId()));
    }
}
