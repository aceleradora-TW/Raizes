alter table produtores
add id_usuario bigint not null;
alter table produtores add constraint fk_usuario foreign key (id_usuario) references usuarios(id);
