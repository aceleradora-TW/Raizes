CREATE TABLE produtos (

  id serial primary key,
  nome varchar(255) not null,
  id_categorias integer not null,
  id_tipo_produtos integer not null,


  constraint fk_categorias foreign key (id_categorias) references categorias(id),
  constraint fk_tipo_produtos foreign key (id_tipo_produtos) references tipo_produtos(id)
);