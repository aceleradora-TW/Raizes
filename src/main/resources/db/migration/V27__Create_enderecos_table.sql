create table enderecos (

  id serial primary key,
  rua varchar(255) not null,
  numero int not null,
  complemento varchar(255),
  bairro varchar(255) not null,
  id_cidades bigint not null,

  constraint fk_cidades foreign key (id_cidades) references cidades(id)

);