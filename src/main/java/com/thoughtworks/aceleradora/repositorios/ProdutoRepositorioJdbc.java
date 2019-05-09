package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositorioJdbc {

    private JdbcTemplate template;

    private static final String BUSCAR_TODOS = "SELECT id, nome FROM produtos";
    private static final String BUSCAR_POR_ID = "SELECT id, nome FROM produtos WHERE id = ?";
    private static final String INSERIR = "INSERT INTO produtos (nome) VALUES (?)";

    public ProdutoRepositorioJdbc(JdbcTemplate template) {
        this.template = template;
    }

    public List<Produto> buscarTodos() {
        return template.query(BUSCAR_TODOS, (resultadoConsulta, numeroDaLinha) -> mapearDadosParaObjeto(resultadoConsulta));
    }

    public Optional<Produto> buscarPorId(Long id) {
        Object[] parametrosDaConsulta = new Object[]{id};

        return template.query(BUSCAR_POR_ID, parametrosDaConsulta, resultadoDaConsulta -> {
            if (resultadoDaConsulta.next()) {
                return Optional.of(mapearDadosParaObjeto(resultadoDaConsulta));
            }

            return Optional.empty();
        });
    }

    public void inserir(Produto produto) {
        template.update(INSERIR, produto.getNome());
    }

    private Produto mapearDadosParaObjeto(ResultSet resultadoDaConsulta) throws SQLException {
        return new Produto(
                resultadoDaConsulta.getLong("id"),
                resultadoDaConsulta.getString("nome")
        );
    }
}
