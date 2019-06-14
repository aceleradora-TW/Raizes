package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.repositorios.ProdutoProdutorRepositorio;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.aceleradora.dominio.TipoDeCultivo.CONVENCIONAL;
import static java.math.BigDecimal.TEN;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ProdutoProdutorServicoTest {

    private ProdutoProdutorServico produtoProdutorServico =
            new ProdutoProdutorServico(mock(ProdutoProdutorRepositorio.class));

    @Test
    public void asdfsadf() {
        List<ProdutoProdutor> produtoProdutores = List.of(
                new ProdutoProdutor() {{
                    setProduto(new Produto() {{
                        setNome("Batata");
                    }});

                    setProdutor(new Produtor() {{
                        setNome("Aldo");
                    }});

                    setPreco(TEN);
                }},

                new ProdutoProdutor() {{
                    setProduto(new Produto() {{
                        setNome("Batata");

                    }});

                    setProdutor(new Produtor() {{
                        setNome("Shakira");
                    }});

                    setPreco(TEN);
                }},

                new ProdutoProdutor() {{
                    setProduto(new Produto() {{
                        setNome("Banana");
                    }});

                    setProdutor(new Produtor() {{
                        setNome("Aldo");
                    }});
                    setPreco(TEN);
                }}
        );

        var listaOrganizada = produtoProdutorServico.organizarProdutoresDeProdutos(produtoProdutores);

        assertThat(listaOrganizada, is(List.of(
                new ProdutoresDeProdutos(
                        new Produto() {{
                            setNome("Batata");
                        }},
                        List.of(
                                new ProdutoProdutor() {{
                                    setProduto(new Produto() {{
                                        setNome("Batata");
                                    }});

                                    setProdutor(new Produtor() {{
                                        setNome("Aldo");
                                    }});

                                    setPreco(TEN);
                                }},

                                new ProdutoProdutor() {{
                                    setProduto(new Produto() {{
                                        setNome("Batata");
                                    }});

                                    setProdutor(new Produtor() {{
                                        setNome("Shakira");
                                    }});
                                    setPreco(TEN);
                                }}
                        )
                ),
                new ProdutoresDeProdutos(
                        new Produto() {{
                            setNome("Banana");
                        }},
                        List.of(
                                new ProdutoProdutor() {{
                                    setProduto(new Produto() {{
                                        setNome("Banana");
                                    }});

                                    setProdutor(new Produtor() {{
                                        setNome("Aldo");
                                    }});
                                    setPreco(TEN);
                                }}
                        )
                )
        )));


    }

    @Test
    public void deveOrganizarComSucessoUmaListaDeProdutoresDeProdutos() {

        //DADO que possuo dois produtos Banana e Maca
        Produto banana = new Produto("Banana", new Categoria(), UnidadeMedida.UNIDADE);
        Produto maca = new Produto("Maca", new Categoria(), UnidadeMedida.UNIDADE);

        //Dado que existe o Leo e o Gab de produtores
        Produtor leoProdutor = new Produtor("Leo", true, new Endereco());
        Produtor gabProdutor = new Produtor("Gab", true, new Endereco());

        //Dado que o Leo produz banana
        ProdutoProdutor leoBananaProdutor = new ProdutoProdutor(10, TEN,
                banana, leoProdutor, CONVENCIONAL);

        //Dado que o Gab produz banana
        ProdutoProdutor gabBananaProdutor = new ProdutoProdutor(10, TEN,
                banana, gabProdutor, CONVENCIONAL);

        //Dado que o Leo produz maca
        ProdutoProdutor leoMacaProdutor = new ProdutoProdutor(10, TEN,
                maca, leoProdutor, CONVENCIONAL);

        //Dado uma lista de ProdutoProdutor
        List<ProdutoProdutor> produtosProdutores = new ArrayList<>();

        //Dado que possuo uma lista de produtores
        produtosProdutores.add(leoBananaProdutor);
        produtosProdutores.add(leoMacaProdutor);
        produtosProdutores.add(gabBananaProdutor);


        //Quando for feito a organizacao dessa lista para ProdutoresDeProdutos

        List<ProdutoresDeProdutos> produtoresDeProdutos = produtoProdutorServico.organizarProdutoresDeProdutos(produtosProdutores);

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