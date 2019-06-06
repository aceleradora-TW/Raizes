alter table pedidos_produtos_produtores
add column id_pedidos bigint;

alter table pedidos_produtos_produtores
add constraint fk_pedidos foreign key (id_pedidos) references pedidos(id);