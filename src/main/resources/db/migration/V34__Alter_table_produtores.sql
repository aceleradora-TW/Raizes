alter table produtores
drop constraint produtores_pkey cascade,
drop constraint fk_enderecos,
drop constraint fk_usuario,
drop column nome,
drop column id_usuario,
drop column id_enderecos,
drop column contato,
add constraint fk_usuario foreign key (id) references usuarios(id);