CREATE TABLE pedido (
    id serial primary key,
    id_lista_produto bigint NOT NULL,
    id_produto_produtor bigint NOT NULL,
    preco_pedido REAL NOT NULL,
    qtd_pedido REAL NOT NULL,

    constraint fk_listas_produtos foreign key (id_lista_produto) references listas_produtos(id),
    constraint fk_produtos_produtor foreign key (id_produto_produtor) references produtos_produtor(id)

);