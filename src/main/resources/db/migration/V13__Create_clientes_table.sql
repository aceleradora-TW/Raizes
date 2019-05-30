create table clientes (
    id serial primary key,
    nome varchar(255) not null,
    id_usuario int not null,

    constraint fk_usuario foreign key (id_usuario) references usuarios(id)

);