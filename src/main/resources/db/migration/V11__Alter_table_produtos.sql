alter table produtos
add id_unidades_medidas bigint not null;
alter table produtos add constraint fk_unidades_medidas foreign key (id_unidades_medidas) references unidades_medidas(id);
