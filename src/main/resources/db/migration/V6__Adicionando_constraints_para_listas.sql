alter table listas add constraint nome_unico UNIQUE(nome);
alter table listas alter column nome set not null;