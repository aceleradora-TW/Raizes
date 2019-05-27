CREATE TABLE produtores (
    id serial primary key,
    nome varchar(255) not null,
    possui_transporte boolean not null
);