create table cidades (

  id serial primary key,
  nome varchar(255) not null,
  id_estados bigint not null,


  constraint fk_estados foreign key (id_estados) references estados(id)

);