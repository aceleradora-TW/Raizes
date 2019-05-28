--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from unidades_medidas;

--Reseta gerador de ids para 1
alter SEQUENCE unidades_medidas_id_seq RESTART with 1;

insert
  into unidades_medidas (nome)
  values ('Kg'), ('Un'), ('L');


--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from listas_produtos;
delete from produtos;
delete from categorias;
delete from tipos_de_cultivos;
delete from listas;

--Reseta gerador de ids para 1
alter SEQUENCE categorias_id_seq RESTART with 1;
alter SEQUENCE tipos_de_cultivos_id_seq RESTART with 1;
alter SEQUENCE produtos_id_seq RESTART with 1;
alter SEQUENCE listas_id_seq RESTART with 1;
alter SEQUENCE listas_produtos_id_seq RESTART with 1;

insert
  into categorias (nome)
  values ('Fruta'), ('Verdura');

insert
  into tipos_de_cultivos (nome)
  values ('Hidroponico'), ('Organico');

insert
  into produtos (nome, id_categorias, id_tipos_de_cultivos, id_unidades_medidas)
  values ('Banana', 1, 2, 1), ('Batata', 2, 2, 1), ('Abacate', 1, 2, 1), ('Beterraba', 2, 2, 1), ('Alface', 2, 1, 2);

insert
  into listas (nome)
  values ('Lista da Jurema'), ('Lista de Domingo');

insert
  into listas_produtos (id_lista, id_produtos)
  values (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 5), (2, 4), (2, 3), (2, 2), (2, 1);


--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from produtores;
delete from produtos_produtores;

--Reseta gerador de ids para 1
alter SEQUENCE produtores_id_seq RESTART with 1;
alter SEQUENCE produtos_produtores_id_seq RESTART with 1;

insert
  into produtores (nome, possui_transporte)
  values ('Aldo', true);

insert
  into produtos_produtores (id_produtores, id_produtos, preco, quantidade_estoque)
  values (1, 1, 3, 50), (1, 2, 4, 70), (1, 3, 3, 35);
