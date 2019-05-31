create table clientes (
    id serial primary key,
    nome varchar(255) not null,
    id_usuarios bigint not null,

    constraint fk_usuarios foreign key (id_usuarios) references usuarios(id)

);