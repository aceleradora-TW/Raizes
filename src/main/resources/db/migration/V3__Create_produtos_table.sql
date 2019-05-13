CREATE TABLE produtos (

  id serial primary key,
  nome varchar(255) not null,
  id_categorias bigint not null,
  id_tipo_produtos bigint not null,


  constraint fk_categorias foreign key (id_categorias) references categorias(id),
  constraint fk_tipos_produtos foreign key (id_tipo_produtos) references tipos_produtos(id)
);