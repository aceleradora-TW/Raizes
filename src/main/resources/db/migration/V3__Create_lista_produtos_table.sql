CREATE TABLE lista_produtos (
    id serial primary key,
    id_produto integer,
    id_lista integer,

    constraint fk_produto foreign key (id_produto) references produtos(id),
    constraint fk_lista foreign key (id_lista) references listas(id)
);