alter table clientes
add id_enderecos int;

alter table clientes 
add constraint fk_enderecos foreign key (id_enderecos) references enderecos(id);