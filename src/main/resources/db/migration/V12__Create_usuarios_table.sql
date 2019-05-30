create table usuarios (
    id serial primary key,
    email varchar(255) not null,
    senha varchar(255) not null,
    tipoUsuario bigint not null
);