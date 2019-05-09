package com.thoughtworks.aceleradora.repositorios;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoRepositorioJdbc {

    private JdbcTemplate template;

    private static final String BUSCAR_TODOS = "SELECT id, nome FROM produtos";

    private final RowMapper<Produto> mapeadorDeProduto = (resultadoConsulta, numeroDaLinha) -> new Produto(
            resultadoConsulta.getLong("id"),
            resultadoConsulta.getString("nome")
    );

    public ProdutoRepositorioJdbc(JdbcTemplate template) {
        this.template = template;
    }

    public List<Produto> buscarTodos() {
        return template.query(BUSCAR_TODOS, mapeadorDeProduto);
    }
}
