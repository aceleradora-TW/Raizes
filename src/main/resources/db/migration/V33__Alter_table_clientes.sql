alter table clientes
drop constraint fk_enderecos,
drop constraint fk_usuarios,
drop constraint clientes_pkey cascade,
drop column id_usuarios,
drop column id_enderecos,
drop column contato,
drop column nome,
add constraint fk_usuario foreign key (id) references usuarios(id);