package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.MinhaListaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MinhaListaServico {

    private MinhaListaRepositorio repositorio;

    public MinhaListaServico(MinhaListaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public MinhaLista salvar(MinhaLista lista) {
        return repositorio.save(lista);
    }

    public Optional<MinhaLista> encontraUm(Long id) {
        return repositorio.findById(id);
    }

    public void deletar(Long id){
         repositorio.deleteById(id);
    }

    public void atualizar(Long id, Long idProduto) {
        Optional<MinhaLista> lista = repositorio.findById(id);
        lista.get().getProdutos().remove(idProduto);

        repositorio.save(lista.get());
    }

    public void removerItem(Long idLista, Long idProduto) {
        Optional<MinhaLista> lista = repositorio.findById(idLista);
        Produto produtoAtual;

        for (int i=0; i<=lista.get().getProdutos().size(); i++) {
            produtoAtual = lista.get().getProdutos().get(i);

            if (produtoAtual.getId() == idProduto){
                lista.get().getProdutos().remove(i);
            }

        }

    }

}
