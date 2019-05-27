CREATE TABLE pedidos (
    id serial primary key,
    id_produtos_produtores bigint NOT NULL,
    qtd_pedido REAL NOT NULL,

    constraint fk_produtos_produtores foreign key (id_produtos_produtores) references produtos_produtores(id)

);