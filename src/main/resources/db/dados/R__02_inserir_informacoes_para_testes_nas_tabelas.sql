update produtos set unidade_medida = 'QUILOGRAMA' where id in (1,2,3,4,5);

update produtos_produtores set tipo_de_cultivo = 'ORGANICO' where id in (1,2,3);

insert
  into usuarios (email, senha, nome, contato, id_endereco, tipo_de_usuario)
    values ('email@produtor.com', 'senha', 'Clotilde', '5555', 1, 'PRODUTOR');

insert
  into produtos (nome, id_categorias, unidade_medida)
  values ('Kiwi', 1, 'QUILOGRAMA'), ('Abacaxi', 1, 'QUILOGRAMA'), ('Laranja', 1, 'QUILOGRAMA'), ('Alface Roxa', 2, 'QUILOGRAMA'), ('Couve Flor', 2, 'QUILOGRAMA');

insert
  into produtores (id, possui_transporte)
  values (3, true);

insert
  into produtos_produtores (id_produtores, id_produtos, preco, quantidade_estoque, tipo_de_cultivo)
  values (3, 1, 3, 50,'ORGANICO'), (3, 2, 4, 70,'ORGANICO'), (3, 8, 3, 35,'ORGANICO');
