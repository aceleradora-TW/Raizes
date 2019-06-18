alter table usuarios
add column nome varchar(255),
add column contato varchar(255),
add column id_endereco int,
add column tipo_de_usuario varchar(255);

alter table usuarios
add constraint fk_enderecos foreign key (id_endereco) references enderecos(id);
