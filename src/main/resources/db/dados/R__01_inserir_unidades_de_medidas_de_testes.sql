-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

DELETE FROM unidades_medidas;

-- Reseta gerador de ids para 1
ALTER SEQUENCE unidades_medidas_id_seq RESTART WITH 1;

INSERT
  INTO unidades_medidas (nome)
  VALUES ('Kg'), ('Un'), ('L');
