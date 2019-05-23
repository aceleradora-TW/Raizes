CREATE TABLE produtos_produtor (
    id serial primary key,
    id_produtor bigint NOT NULL,
    id_produtos bigint NOT NULL,
    preco REAL NOT NULL,
    qtd_estoque REAL NOT NULL,

    constraint fk_produtor foreign key (id_produtor) references produtor(id),
    constraint fk_produto foreign key (id_produtos) references produtos(id)

);