create table pedidos (
    id serial primary key,
    id_produtos_produtores bigint not null,
    quantidade_pedido real not null,

    constraint fk_produtos_produtores foreign key (id_produtos_produtores) references produtos_produtores(id)

);