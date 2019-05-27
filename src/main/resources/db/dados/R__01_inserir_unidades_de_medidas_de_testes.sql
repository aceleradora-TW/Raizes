-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

delete from unidades_medidas;

-- Reseta gerador de ids para 1
alter SEQUENCE unidades_medidas_id_seq RESTART with 1;

insert
  into unidades_medidas (nome)
  values ('Kg'), ('Un'), ('L');
