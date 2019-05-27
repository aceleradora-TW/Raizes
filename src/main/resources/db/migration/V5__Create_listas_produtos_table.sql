create table listas_produtos (
    id serial primary key,
    id_produtos bigint not null,
    id_lista bigint not null,

    constraint fk_produtos foreign key (id_produtos) references produtos(id),
    constraint fk_listas foreign key (id_lista) references listas(id)

);