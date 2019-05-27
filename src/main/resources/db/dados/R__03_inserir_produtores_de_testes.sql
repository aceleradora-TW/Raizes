-- Remove todos os dados das tabelas para evitar duplicacoes de dados de teste

delete from produtores;
delete from produtos_produtores;

-- Reseta gerador de ids para 1
alter SEQUENCE produtores_id_seq RESTART with 1;
alter SEQUENCE produtos_produtores_id_seq RESTART with 1;

insert
  into produtores (nome, possui_transporte)
  values ('Aldo', true);

insert
  into produtos_produtores (id_produtores, id_produtos, preco, quantidade_estoque)
  values (1, 1, 3, 50), (1, 2, 4, 70), (1, 3, 3, 35);
