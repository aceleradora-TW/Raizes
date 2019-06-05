alter table produtos
drop column id_categorias,
drop column id_unidades_medidas,
drop column id_tipos_de_cultivos;

alter table produtos
add column categoria varchar(255),
add column unidade_medida varchar(255);