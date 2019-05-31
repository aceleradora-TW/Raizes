create table compras (

  id serial primary key,
  nome varchar(255) not null,
  id_pedidos bigint not null,
  id_clientes bigint not null,


  constraint fk_pedidos foreign key (id_pedidos) references pedidos(id),
  constraint fk_clientes foreign key (id_clientes) references clientes(id)
);