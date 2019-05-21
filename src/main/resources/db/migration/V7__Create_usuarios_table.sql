 create table usuario(
  id serial primary key,
  nome varchar(100) not null,
  sobrenome varchar(100) not null,
  tipoDeUsuarios varchar(100) not null,
  senha varchar(100) not null
);