CREATE TABLE produtos_produtores (
    id serial primary key,
    id_produtores bigint NOT NULL,
    id_produtos bigint NOT NULL,
    preco REAL NOT NULL,
    qtd_estoque REAL NOT NULL,

    constraint fk_produtores foreign key (id_produtores) references produtores(id),
    constraint fk_produtos foreign key (id_produtos) references produtos(id)

);