create table produtos_produtores (
    id serial primary key,
    id_produtores bigint not null,
    id_produtos bigint not null,
    preco real not null,
    quantidade_estoque real not null,

    constraint fk_produtores foreign key (id_produtores) references produtores(id),
    constraint fk_produtos foreign key (id_produtos) references produtos(id)

);