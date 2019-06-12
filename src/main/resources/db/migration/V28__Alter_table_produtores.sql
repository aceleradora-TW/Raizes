alter table produtores
add id_enderecos int;

alter table produtores 
add constraint fk_enderecos foreign key (id_enderecos) references enderecos(id);