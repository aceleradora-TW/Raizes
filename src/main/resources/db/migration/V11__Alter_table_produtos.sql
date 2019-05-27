ALTER TABLE produtos
ADD id_unidades_medidas bigint NOT NULL;
ALTER TABLE produtos ADD constraint fk_unidades_medidas foreign key (id_unidades_medidas) references unidades_medidas(id);
