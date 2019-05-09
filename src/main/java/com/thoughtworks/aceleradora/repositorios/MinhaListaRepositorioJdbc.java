package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MinhaListaRepositorioJdbc {

    private JdbcTemplate template;

    private static final String BUSCAR_POR_ID = "SELECT id, nome FROM listas WHERE id = ?";

    private static final String BUSCA = "select listas.id, listas.nome, produtos.id, produtos.nome" +
            " from lista_produtos" +
            " inner join listas on listas.id = lista_produtos.id_lista" +
            " inner join produtos on produtos.id = lista_produtos.id_produto" +
            " where lista_produtos.id_lista = ?";

    public MinhaListaRepositorioJdbc(JdbcTemplate template) {
        this.template = template;
    }

    public Optional<MinhaLista> buscarPorId(Long id) {
        Object[] parametrosDaConsulta = new Object[]{id};

        return template.query(BUSCA, parametrosDaConsulta, (resultadoDaConsulta) -> {

            if (resultadoDaConsulta.first()) {
                MinhaLista lista = new MinhaLista();
                lista.setId(resultadoDaConsulta.getLong("listas.id"));
                lista.setNome(resultadoDaConsulta.getString("listas.nome"));

                List<Produto> produtos = new ArrayList<>();

                Produto primeiroProduto = new Produto(
                        resultadoDaConsulta.getLong("produtos.id"),
                        resultadoDaConsulta.getString("produtos.nome")
                );

                produtos.add(primeiroProduto);

                while (resultadoDaConsulta.next()) {
                    produtos.add(new Produto(
                            resultadoDaConsulta.getLong("produtos.id"),
                            resultadoDaConsulta.getString("produtos.nome"))
                    );
                }

                lista.setProdutos(produtos);

                return Optional.of(lista);
            }

            return Optional.empty();
        });
    }

    private MinhaLista mapearDadosParaObjeto(ResultSet resultadoDaConsulta) throws SQLException {
        return new MinhaLista(
                resultadoDaConsulta.getLong("listas.id"),
                resultadoDaConsulta.getString("listas.nome")
        );
    }

}
