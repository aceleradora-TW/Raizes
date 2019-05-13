CREATE TABLE listas_produtos (
    id serial primary key,
    id_produto integer not null,
    id_lista integer not null,

    constraint fk_produto foreign key (id_produto) references produtos(id),
    constraint fk_lista foreign key (id_lista) references listas(id)

);