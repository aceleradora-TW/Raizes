CREATE TABLE produtos (

  id serial primary key,
  nome varchar(255) not null,
  id_categorias integer not null,


  constraint fk_categorias foreign key (id_categorias) references categorias(id)
);