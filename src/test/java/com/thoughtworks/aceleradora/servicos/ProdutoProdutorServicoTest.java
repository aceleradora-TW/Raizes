package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

public class ProdutoProdutorServicoTest {

    @Test
    public void deveOrganizarComSucessoUmaListaDeProdutoresDeProdutos() {

        //DADO que possuo dois produtos Banana e Maca
        Produto banana = new Produto("Banana", new Categoria(), UnidadeMedida.UNIDADE);
        Produto maca = new Produto("Maca", new Categoria(), UnidadeMedida.UNIDADE);

        //Dado que existe o Leo e o Gab de produtores
        Produtor leoProdutor = new Produtor("Leo", true, new Endereco());
        Produtor gabProdutor = new Produtor("Gab", true, new Endereco());

        //Dado que o Leo produz banana
        ProdutoProdutor leoBananaProdutor = new ProdutoProdutor(10, BigDecimal.TEN,
                banana, leoProdutor, TipoDeCultivo.CONVENCIONAL);

        //Dado que o Gab produz banana
        ProdutoProdutor gabBananaProdutor = new ProdutoProdutor(10, BigDecimal.TEN,
                banana, gabProdutor, TipoDeCultivo.CONVENCIONAL);

        //Dado que o Leo produz maca
        ProdutoProdutor leoMacaProdutor = new ProdutoProdutor(10, BigDecimal.TEN,
                maca, leoProdutor, TipoDeCultivo.CONVENCIONAL);

        //Dado uma lista de ProdutoProdutor
        List<ProdutoProdutor> produtosProdutores = new ArrayList<>();

        //Dado que possuo uma lista de produtores
        produtosProdutores.add(leoBananaProdutor);
        produtosProdutores.add(leoMacaProdutor);
        produtosProdutores.add(gabBananaProdutor);


        //Quando for feito a organizacao dessa lista para ProdutoresDeProdutos
        ProdutoProdutorServico produtoProdutorServico =
                new ProdutoProdutorServico(mock(ProdutoProdutorRepositorio.class));
        List<ProdutoresDeProdutos> produtoresDeProdutos =
                produtoProdutorServico.organizarProdutoresDeProdutos(produtosProdutores);

        //Entao deve retornar uma lista de produtores de produtos distintos

        assertThat(produtoresDeProdutos.size(), equalTo(2));

        for (ProdutoresDeProdutos produtoOrganizado : produtoresDeProdutos) {
            if (produtoOrganizado.getProduto().equals(banana)) {
                assertThat(produtoOrganizado.getProdutores().size(), equalTo(2));
            } else {
                assertThat(produtoOrganizado.getProdutores().size(), equalTo(1));
                assertThat(produtoOrganizado.getProdutores().get(0), equalTo(leoProdutor));
            }
        }
    }

}