alter table listas
add id_clientes bigint not null;
alter table listas add constraint fk_clientes foreign key (id_clientes) references clientes(id);
