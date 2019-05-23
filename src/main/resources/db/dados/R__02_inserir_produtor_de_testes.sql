-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

DELETE FROM produtor;
DELETE FROM produtos_produtor;

-- Reseta gerador de ids para 1
ALTER SEQUENCE produtor_id_seq RESTART WITH 1;
ALTER SEQUENCE produtos_produtor_id_seq RESTART WITH 1;

INSERT
  INTO produtor (nome)
  VALUES ('Aldo');

INSERT
  INTO produtos_produtor (id_produtor, id_produtos, preco, qtd_estoque)
  VALUES (1, 1, 3, 50), (1, 2, 4, 70), (1, 3, 3, 35);
