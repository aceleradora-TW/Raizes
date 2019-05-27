-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

DELETE FROM listas_produtos;
DELETE FROM produtos;
DELETE FROM categorias;
DELETE FROM tipos_de_cultivos;
DELETE FROM listas;

-- Reseta gerador de ids para 1
ALTER SEQUENCE categorias_id_seq RESTART WITH 1;
ALTER SEQUENCE tipos_de_cultivos_id_seq RESTART WITH 1;
ALTER SEQUENCE produtos_id_seq RESTART WITH 1;
ALTER SEQUENCE listas_id_seq RESTART WITH 1;
ALTER SEQUENCE listas_produtos_id_seq RESTART WITH 1;

INSERT
  INTO categorias (nome)
  VALUES ('Fruta'), ('Verdura');

INSERT
  INTO tipos_de_cultivos (nome)
  VALUES ('Hidroponico'), ('Organico');

INSERT
  INTO produtos (nome, id_categorias, id_tipos_de_cultivos, id_unidades_medidas)
  VALUES ('Banana', 1, 2, 1), ('Batata', 2, 2, 1), ('Abacate', 1, 2, 1), ('Beterraba', 2, 2, 1), ('Alface', 2, 1, 2);

INSERT
  INTO listas (nome)
  VALUES ('Lista da Jurema'), ('Lista de Domingo');

INSERT
  INTO listas_produtos (id_lista, id_produtos)
  VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 5), (2, 4), (2, 3), (2, 2), (2, 1);