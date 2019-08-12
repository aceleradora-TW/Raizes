alter table listas
add column titulo varchar(255);

update listas
set titulo=nome;

alter table listas
drop column nome;

alter table listas rename
column titulo to nome;

alter table listas
alter column nome set not null;
