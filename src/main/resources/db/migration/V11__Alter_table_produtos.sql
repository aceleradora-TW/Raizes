ALTER TABLE produtos
ADD id_unidade_medida bigint NOT NULL;
ALTER TABLE produtos ADD constraint fk_unidade_medida foreign key (id_unidade_medida) references unidade_medida(id);
