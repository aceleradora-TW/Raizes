-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

DELETE FROM unidade_medida;

-- Reseta gerador de ids para 1
ALTER SEQUENCE unidade_medida_id_seq RESTART WITH 1;

INSERT
  INTO unidade_medida (nome)
  VALUES ('Kg'), ('Un'), ('L');
