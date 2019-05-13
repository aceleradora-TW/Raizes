CREATE TABLE listas_produtos (
    id serial primary key,
    id_produto bigint not null,
    id_lista bigint not null,

    constraint fk_produtos foreign key (id_produto) references produtos(id),
    constraint fk_listas foreign key (id_lista) references listas(id)

);