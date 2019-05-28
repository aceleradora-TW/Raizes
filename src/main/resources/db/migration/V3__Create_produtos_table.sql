create table produtos (

  id serial primary key,
  nome varchar(255) not null,
  id_categorias bigint not null,
  id_tipos_de_cultivos bigint not null,


  constraint fk_categorias foreign key (id_categorias) references categorias(id),
  constraint fk_tipos_de_cultivos foreign key (id_tipos_de_cultivos) references tipos_de_cultivos(id)
);