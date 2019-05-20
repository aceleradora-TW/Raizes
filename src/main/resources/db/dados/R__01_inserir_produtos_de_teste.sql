-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
DELETE FROM categorias;
DELETE FROM tipos_de_cultivos;
DELETE FROM produtos;

-- Reseta gerador de ids para 1
ALTER SEQUENCE categorias_id_seq RESTART WITH 1;
ALTER SEQUENCE tipos_de_cultivos_id_seq RESTART WITH 1;
ALTER SEQUENCE produtos_id_seq RESTART WITH 1;

INSERT
  INTO categorias (nome)
  VALUES ('Fruta'), ('Verdura');

INSERT
  INTO tipos_de_cultivos (nome)
  VALUES ('Hidroponico'), ('Organico');

INSERT
  INTO produtos (nome, id_categorias, id_tipos_de_cultivos)
  VALUES ('Banana', 1, 2), ('Batata', 2, 2), ('Abacate', 1, 2), ('Beterraba', 2, 2), ('Alface', 2, 1);