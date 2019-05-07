ALTER TABLE produtos ADD column id_categorias integer;

alter table produtos
    add constraint fk_categorias
        foreign key (id_categorias)
            references categorias(id);
;