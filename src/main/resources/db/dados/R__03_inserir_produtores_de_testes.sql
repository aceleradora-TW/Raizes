-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

DELETE FROM produtores;
DELETE FROM produtos_produtores;

-- Reseta gerador de ids para 1
ALTER SEQUENCE produtores_id_seq RESTART WITH 1;
ALTER SEQUENCE produtos_produtores_id_seq RESTART WITH 1;

INSERT
  INTO produtores (nome, possui_transporte)
  VALUES ('Aldo', true);

INSERT
  INTO produtos_produtores (id_produtores, id_produtos, preco, qtd_estoque)
  VALUES (1, 1, 3, 50), (1, 2, 4, 70), (1, 3, 3, 35);
