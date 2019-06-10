alter table produtos
drop column id_unidades_medidas,
drop column id_tipos_de_cultivos;

alter table produtos
add column unidade_medida varchar(255);