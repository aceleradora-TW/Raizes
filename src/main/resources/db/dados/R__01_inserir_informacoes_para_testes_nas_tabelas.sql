--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from listas_produtos;
delete from produtos;
delete from categorias;
delete from listas;
delete from clientes;
delete from usuarios;
delete from produtores;
delete from produtos_produtores;
delete from estados;
delete from cidades;
delete from enderecos;

--Reseta gerador de ids para 1
alter SEQUENCE categorias_id_seq RESTART with 1;
alter SEQUENCE produtos_id_seq RESTART with 1;
alter SEQUENCE listas_id_seq RESTART with 1;
alter SEQUENCE listas_produtos_id_seq RESTART with 1;
alter SEQUENCE clientes_id_seq RESTART with 1;
alter SEQUENCE compras_id_seq RESTART with 1;
alter SEQUENCE usuarios_id_seq RESTART with 1;
alter SEQUENCE produtores_id_seq RESTART with 1;
alter SEQUENCE produtos_produtores_id_seq RESTART with 1;
alter SEQUENCE estados_id_seq RESTART with 1;
alter SEQUENCE cidades_id_seq RESTART with 1;
alter SEQUENCE enderecos_id_seq RESTART with 1;

insert
  into usuarios (email, senha)
  values ('email@produtor.com', 'senha'), ('email@cliente.com', 'senha');

insert
  into categorias (nome)
  values ('Fruta'), ('Verdura');



insert
  into produtos (nome, id_categorias)
  values ('Banana', 1), ('Batata', 2), ('Abacate', 1), ('Beterraba', 2), ('Alface', 2);

insert
  into clientes (nome, id_usuarios)
  values ('Neiva', 2);

insert
  into listas (nome , id_clientes)
  values ('Lista da Jurema', 1), ('Lista de Domingo', 1);

insert
  into listas_produtos (id_lista, id_produtos)
  values (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 5), (2, 4), (2, 3), (2, 2), (2, 1);


insert
  into produtores (nome, possui_transporte, id_usuario)
  values ('Aldo', true, 1);

insert
  into produtos_produtores (id_produtores, id_produtos, preco, quantidade_estoque)
  values (1, 1, 3, 50), (1, 2, 4, 70), (1, 3, 3, 35);

insert
  into estados(uf)
  values ('RS');

insert
    into cidades(nome, id_estados)
    values('Aceguá', 1);

insert
    into cidades(nome, id_estados)
    values('Água Santa', 1);

insert
    into cidades(nome, id_estados)
    values('Agudo', 1);

insert
    into cidades(nome, id_estados)
    values('Ajuricaba', 1);

insert
    into cidades(nome, id_estados)
    values('Alecrim', 1);

insert
    into cidades(nome, id_estados)
    values('Alegrete', 1);

insert
    into cidades(nome, id_estados)
    values('Alegria', 1);

insert
    into cidades(nome, id_estados)
    values('Almirante Tamandaré do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Alpestre', 1);

insert
    into cidades(nome, id_estados)
    values('Alto Alegre', 1);

insert
    into cidades(nome, id_estados)
    values('Alto Feliz', 1);

insert
    into cidades(nome, id_estados)
    values('Alvorada', 1);

insert
    into cidades(nome, id_estados)
    values('Amaral Ferrador', 1);

insert
    into cidades(nome, id_estados)
    values('Ametista do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('André da Rocha', 1);

insert
    into cidades(nome, id_estados)
    values('Anta Gorda', 1);

insert
    into cidades(nome, id_estados)
    values('Antônio Prado', 1);

insert
    into cidades(nome, id_estados)
    values('Arambaré', 1);

insert
    into cidades(nome, id_estados)
    values('Araricá', 1);

insert
    into cidades(nome, id_estados)
    values('Aratiba', 1);

insert
    into cidades(nome, id_estados)
    values('Arroio do Meio', 1);

insert
    into cidades(nome, id_estados)
    values('Arroio do Padre', 1);

insert
    into cidades(nome, id_estados)
    values('Arroio do Sal', 1);

insert
    into cidades(nome, id_estados)
    values('Arroio do Tigre', 1);

insert
    into cidades(nome, id_estados)
    values('Arroio dos Ratos', 1);

insert
    into cidades(nome, id_estados)
    values('Arroio Grande', 1);

insert
    into cidades(nome, id_estados)
    values('Arvorezinha', 1);

insert
    into cidades(nome, id_estados)
    values('Pinto Bandeira', 1);

insert
    into cidades(nome, id_estados)
    values('Augusto Pestana', 1);

insert
    into cidades(nome, id_estados)
    values('Áurea', 1);

insert
    into cidades(nome, id_estados)
    values('Bagé', 1);

insert
    into cidades(nome, id_estados)
    values('Balneário Pinhal', 1);

insert
    into cidades(nome, id_estados)
    values('Barão', 1);

insert
    into cidades(nome, id_estados)
    values('Barão de Cotegipe', 1);

insert
    into cidades(nome, id_estados)
    values('Barão do Triunfo', 1);

insert
    into cidades(nome, id_estados)
    values('Barra do Guarita', 1);

insert
    into cidades(nome, id_estados)
    values('Barra do Quaraí', 1);

insert
    into cidades(nome, id_estados)
    values('Barra do Ribeiro', 1);

insert
    into cidades(nome, id_estados)
    values('Barra do Rio Azul', 1);

insert
    into cidades(nome, id_estados)
    values('Barra Funda', 1);

insert
    into cidades(nome, id_estados)
    values('Barracão', 1);

insert
    into cidades(nome, id_estados)
    values('Barros Cassal', 1);

insert
    into cidades(nome, id_estados)
    values('Benjamin Constant do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Bento Gonçalves', 1);

insert
    into cidades(nome, id_estados)
    values('Boa Vista das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Boa Vista do Buricá', 1);

insert
    into cidades(nome, id_estados)
    values('Boa Vista do Cadeado', 1);

insert
    into cidades(nome, id_estados)
    values('Boa Vista do Incra', 1);

insert
    into cidades(nome, id_estados)
    values('Boa Vista do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Bom Jesus', 1);

insert
    into cidades(nome, id_estados)
    values('Bom Princípio', 1);

insert
    into cidades(nome, id_estados)
    values('Bom Progresso', 1);

insert
    into cidades(nome, id_estados)
    values('Bom Retiro do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Boqueirão do Leão', 1);

insert
    into cidades(nome, id_estados)
    values('Bossoroca', 1);

insert
    into cidades(nome, id_estados)
    values('Bozano', 1);

insert
    into cidades(nome, id_estados)
    values('Braga', 1);

insert
    into cidades(nome, id_estados)
    values('Brochier', 1);

insert
    into cidades(nome, id_estados)
    values('Butiá', 1);

insert
    into cidades(nome, id_estados)
    values('Caçapava do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Cacequi', 1);

insert
    into cidades(nome, id_estados)
    values('Cachoeira do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Cachoeirinha', 1);

insert
    into cidades(nome, id_estados)
    values('Cacique Doble', 1);

insert
    into cidades(nome, id_estados)
    values('Caibaté', 1);

insert
    into cidades(nome, id_estados)
    values('Caiçara', 1);

insert
    into cidades(nome, id_estados)
    values('Camaquã', 1);

insert
    into cidades(nome, id_estados)
    values('Camargo', 1);

insert
    into cidades(nome, id_estados)
    values('Cambará do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Campestre da Serra', 1);

insert
    into cidades(nome, id_estados)
    values('Campina das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Campinas do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Campo Bom', 1);

insert
    into cidades(nome, id_estados)
    values('Campo Novo', 1);

insert
    into cidades(nome, id_estados)
    values('Campos Borges', 1);

insert
    into cidades(nome, id_estados)
    values('Candelária', 1);

insert
    into cidades(nome, id_estados)
    values('Cândido Godói', 1);

insert
    into cidades(nome, id_estados)
    values('Candiota', 1);

insert
    into cidades(nome, id_estados)
    values('Canela', 1);

insert
    into cidades(nome, id_estados)
    values('Canguçu', 1);

insert
    into cidades(nome, id_estados)
    values('Canoas', 1);

insert
    into cidades(nome, id_estados)
    values('Canudos do Vale', 1);

insert
    into cidades(nome, id_estados)
    values('Capão Bonito do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Capão da Canoa', 1);

insert
    into cidades(nome, id_estados)
    values('Capão do Cipó', 1);

insert
    into cidades(nome, id_estados)
    values('Capão do Leão', 1);

insert
    into cidades(nome, id_estados)
    values('Capela de Santana', 1);

insert
    into cidades(nome, id_estados)
    values('Capitão', 1);

insert
    into cidades(nome, id_estados)
    values('Capivari do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Caraá', 1);

insert
    into cidades(nome, id_estados)
    values('Carazinho', 1);

insert
    into cidades(nome, id_estados)
    values('Carlos Barbosa', 1);

insert
    into cidades(nome, id_estados)
    values('Carlos Gomes', 1);

insert
    into cidades(nome, id_estados)
    values('Casca', 1);

insert
    into cidades(nome, id_estados)
    values('Caseiros', 1);

insert
    into cidades(nome, id_estados)
    values('Catuípe', 1);

insert
    into cidades(nome, id_estados)
    values('Caxias do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Centenário', 1);

insert
    into cidades(nome, id_estados)
    values('Cerrito', 1);

insert
    into cidades(nome, id_estados)
    values('Cerro Branco', 1);

insert
    into cidades(nome, id_estados)
    values('Cerro Grande', 1);

insert
    into cidades(nome, id_estados)
    values('Cerro Grande do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Cerro Largo', 1);

insert
    into cidades(nome, id_estados)
    values('Chapada', 1);

insert
    into cidades(nome, id_estados)
    values('Charqueadas', 1);

insert
    into cidades(nome, id_estados)
    values('Charrua', 1);

insert
    into cidades(nome, id_estados)
    values('Chiapetta', 1);

insert
    into cidades(nome, id_estados)
    values('Chuí', 1);

insert
    into cidades(nome, id_estados)
    values('Chuvisca', 1);

insert
    into cidades(nome, id_estados)
    values('Cidreira', 1);

insert
    into cidades(nome, id_estados)
    values('Ciríaco', 1);

insert
    into cidades(nome, id_estados)
    values('Colinas', 1);

insert
    into cidades(nome, id_estados)
    values('Colorado', 1);

insert
    into cidades(nome, id_estados)
    values('Condor', 1);

insert
    into cidades(nome, id_estados)
    values('Constantina', 1);

insert
    into cidades(nome, id_estados)
    values('Coqueiro Baixo', 1);

insert
    into cidades(nome, id_estados)
    values('Coqueiros do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Coronel Barros', 1);

insert
    into cidades(nome, id_estados)
    values('Coronel Bicaco', 1);

insert
    into cidades(nome, id_estados)
    values('Coronel Pilar', 1);

insert
    into cidades(nome, id_estados)
    values('Cotiporã', 1);

insert
    into cidades(nome, id_estados)
    values('Coxilha', 1);

insert
    into cidades(nome, id_estados)
    values('Crissiumal', 1);

insert
    into cidades(nome, id_estados)
    values('Cristal', 1);

insert
    into cidades(nome, id_estados)
    values('Cristal do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Cruz Alta', 1);

insert
    into cidades(nome, id_estados)
    values('Cruzaltense', 1);

insert
    into cidades(nome, id_estados)
    values('Cruzeiro do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('David Canabarro', 1);

insert
    into cidades(nome, id_estados)
    values('Derrubadas', 1);

insert
    into cidades(nome, id_estados)
    values('Dezesseis de Novembro', 1);

insert
    into cidades(nome, id_estados)
    values('Dilermando de Aguiar', 1);

insert
    into cidades(nome, id_estados)
    values('Dois Irmãos', 1);

insert
    into cidades(nome, id_estados)
    values('Dois Irmãos das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Dois Lajeados', 1);

insert
    into cidades(nome, id_estados)
    values('Dom Feliciano', 1);

insert
    into cidades(nome, id_estados)
    values('Dom Pedrito', 1);

insert
    into cidades(nome, id_estados)
    values('Dom Pedro de Alcântara', 1);

insert
    into cidades(nome, id_estados)
    values('Dona Francisca', 1);

insert
    into cidades(nome, id_estados)
    values('Doutor Maurício Cardoso', 1);

insert
    into cidades(nome, id_estados)
    values('Doutor Ricardo', 1);

insert
    into cidades(nome, id_estados)
    values('Eldorado do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Encantado', 1);

insert
    into cidades(nome, id_estados)
    values('Encruzilhada do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Engenho Velho', 1);

insert
    into cidades(nome, id_estados)
    values('Entre Rios do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Entre-Ijuís', 1);

insert
    into cidades(nome, id_estados)
    values('Erebango', 1);

insert
    into cidades(nome, id_estados)
    values('Erechim', 1);

insert
    into cidades(nome, id_estados)
    values('Ernestina', 1);

insert
    into cidades(nome, id_estados)
    values('Erval Grande', 1);

insert
    into cidades(nome, id_estados)
    values('Erval Seco', 1);

insert
    into cidades(nome, id_estados)
    values('Esmeralda', 1);

insert
    into cidades(nome, id_estados)
    values('Esperança do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Espumoso', 1);

insert
    into cidades(nome, id_estados)
    values('Estação', 1);

insert
    into cidades(nome, id_estados)
    values('Estância Velha', 1);

insert
    into cidades(nome, id_estados)
    values('Esteio', 1);

insert
    into cidades(nome, id_estados)
    values('Estrela', 1);

insert
    into cidades(nome, id_estados)
    values('Estrela Velha', 1);

insert
    into cidades(nome, id_estados)
    values('Eugênio de Castro', 1);

insert
    into cidades(nome, id_estados)
    values('Fagundes Varela', 1);

insert
    into cidades(nome, id_estados)
    values('Farroupilha', 1);

insert
    into cidades(nome, id_estados)
    values('Faxinal do Soturno', 1);

insert
    into cidades(nome, id_estados)
    values('Faxinalzinho', 1);

insert
    into cidades(nome, id_estados)
    values('Fazenda Vilanova', 1);

insert
    into cidades(nome, id_estados)
    values('Feliz', 1);

insert
    into cidades(nome, id_estados)
    values('Flores da Cunha', 1);

insert
    into cidades(nome, id_estados)
    values('Floriano Peixoto', 1);

insert
    into cidades(nome, id_estados)
    values('Fontoura Xavier', 1);

insert
    into cidades(nome, id_estados)
    values('Formigueiro', 1);

insert
    into cidades(nome, id_estados)
    values('Forquetinha', 1);

insert
    into cidades(nome, id_estados)
    values('Fortaleza dos Valos', 1);

insert
    into cidades(nome, id_estados)
    values('Frederico Westphalen', 1);

insert
    into cidades(nome, id_estados)
    values('Garibaldi', 1);

insert
    into cidades(nome, id_estados)
    values('Garruchos', 1);

insert
    into cidades(nome, id_estados)
    values('Gaurama', 1);

insert
    into cidades(nome, id_estados)
    values('General Câmara', 1);

insert
    into cidades(nome, id_estados)
    values('Gentil', 1);

insert
    into cidades(nome, id_estados)
    values('Getúlio Vargas', 1);

insert
    into cidades(nome, id_estados)
    values('Giruá', 1);

insert
    into cidades(nome, id_estados)
    values('Glorinha', 1);

insert
    into cidades(nome, id_estados)
    values('Gramado', 1);

insert
    into cidades(nome, id_estados)
    values('Gramado dos Loureiros', 1);

insert
    into cidades(nome, id_estados)
    values('Gramado Xavier', 1);

insert
    into cidades(nome, id_estados)
    values('Gravataí', 1);

insert
    into cidades(nome, id_estados)
    values('Guabiju', 1);

insert
    into cidades(nome, id_estados)
    values('Guaíba', 1);

insert
    into cidades(nome, id_estados)
    values('Guaporé', 1);

insert
    into cidades(nome, id_estados)
    values('Guarani das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Harmonia', 1);

insert
    into cidades(nome, id_estados)
    values('Herval', 1);

insert
    into cidades(nome, id_estados)
    values('Herveiras', 1);

insert
    into cidades(nome, id_estados)
    values('Horizontina', 1);

insert
    into cidades(nome, id_estados)
    values('Hulha Negra', 1);

insert
    into cidades(nome, id_estados)
    values('Humaitá', 1);

insert
    into cidades(nome, id_estados)
    values('Ibarama', 1);

insert
    into cidades(nome, id_estados)
    values('Ibiaçá', 1);

insert
    into cidades(nome, id_estados)
    values('Ibiraiaras', 1);

insert
    into cidades(nome, id_estados)
    values('Ibirapuitã', 1);

insert
    into cidades(nome, id_estados)
    values('Ibirubá', 1);

insert
    into cidades(nome, id_estados)
    values('Igrejinha', 1);

insert
    into cidades(nome, id_estados)
    values('Ijuí', 1);

insert
    into cidades(nome, id_estados)
    values('Ilópolis', 1);

insert
    into cidades(nome, id_estados)
    values('Imbé', 1);

insert
    into cidades(nome, id_estados)
    values('Imigrante', 1);

insert
    into cidades(nome, id_estados)
    values('Independência', 1);

insert
    into cidades(nome, id_estados)
    values('Inhacorá', 1);

insert
    into cidades(nome, id_estados)
    values('Ipê', 1);

insert
    into cidades(nome, id_estados)
    values('Ipiranga do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Iraí', 1);

insert
    into cidades(nome, id_estados)
    values('Itaara', 1);

insert
    into cidades(nome, id_estados)
    values('Itacurubi', 1);

insert
    into cidades(nome, id_estados)
    values('Itapuca', 1);

insert
    into cidades(nome, id_estados)
    values('Itaqui', 1);

insert
    into cidades(nome, id_estados)
    values('Itati', 1);

insert
    into cidades(nome, id_estados)
    values('Itatiba do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Ivorá', 1);

insert
    into cidades(nome, id_estados)
    values('Ivoti', 1);

insert
    into cidades(nome, id_estados)
    values('Jaboticaba', 1);

insert
    into cidades(nome, id_estados)
    values('Jacuizinho', 1);

insert
    into cidades(nome, id_estados)
    values('Jacutinga', 1);

insert
    into cidades(nome, id_estados)
    values('Jaguarão', 1);

insert
    into cidades(nome, id_estados)
    values('Jaguari', 1);

insert
    into cidades(nome, id_estados)
    values('Jaquirana', 1);

insert
    into cidades(nome, id_estados)
    values('Jari', 1);

insert
    into cidades(nome, id_estados)
    values('Jóia', 1);

insert
    into cidades(nome, id_estados)
    values('Júlio de Castilhos', 1);

insert
    into cidades(nome, id_estados)
    values('Lagoa Bonita do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Lagoa dos Três Cantos', 1);

insert
    into cidades(nome, id_estados)
    values('Lagoa Vermelha', 1);

insert
    into cidades(nome, id_estados)
    values('Lagoão', 1);

insert
    into cidades(nome, id_estados)
    values('Lajeado', 1);

insert
    into cidades(nome, id_estados)
    values('Lajeado do Bugre', 1);

insert
    into cidades(nome, id_estados)
    values('Lavras do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Liberato Salzano', 1);

insert
    into cidades(nome, id_estados)
    values('Lindolfo Collor', 1);

insert
    into cidades(nome, id_estados)
    values('Linha Nova', 1);

insert
    into cidades(nome, id_estados)
    values('Maçambara', 1);

insert
    into cidades(nome, id_estados)
    values('Machadinho', 1);

insert
    into cidades(nome, id_estados)
    values('Mampituba', 1);

insert
    into cidades(nome, id_estados)
    values('Manoel Viana', 1);

insert
    into cidades(nome, id_estados)
    values('Maquiné', 1);

insert
    into cidades(nome, id_estados)
    values('Maratá', 1);

insert
    into cidades(nome, id_estados)
    values('Marau', 1);

insert
    into cidades(nome, id_estados)
    values('Marcelino Ramos', 1);

insert
    into cidades(nome, id_estados)
    values('Mariana Pimentel', 1);

insert
    into cidades(nome, id_estados)
    values('Mariano Moro', 1);

insert
    into cidades(nome, id_estados)
    values('Marques de Souza', 1);

insert
    into cidades(nome, id_estados)
    values('Mata', 1);

insert
    into cidades(nome, id_estados)
    values('Mato Castelhano', 1);

insert
    into cidades(nome, id_estados)
    values('Mato Leitão', 1);

insert
    into cidades(nome, id_estados)
    values('Mato Queimado', 1);

insert
    into cidades(nome, id_estados)
    values('Maximiliano de Almeida', 1);

insert
    into cidades(nome, id_estados)
    values('Minas do Leão', 1);

insert
    into cidades(nome, id_estados)
    values('Miraguaí', 1);

insert
    into cidades(nome, id_estados)
    values('Montauri', 1);

insert
    into cidades(nome, id_estados)
    values('Monte Alegre dos Campos', 1);

insert
    into cidades(nome, id_estados)
    values('Monte Belo do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Montenegro', 1);

insert
    into cidades(nome, id_estados)
    values('Mormaço', 1);

insert
    into cidades(nome, id_estados)
    values('Morrinhos do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Morro Redondo', 1);

insert
    into cidades(nome, id_estados)
    values('Morro Reuter', 1);

insert
    into cidades(nome, id_estados)
    values('Mostardas', 1);

insert
    into cidades(nome, id_estados)
    values('Muçum', 1);

insert
    into cidades(nome, id_estados)
    values('Muitos Capões', 1);

insert
    into cidades(nome, id_estados)
    values('Muliterno', 1);

insert
    into cidades(nome, id_estados)
    values('Não-Me-Toque', 1);

insert
    into cidades(nome, id_estados)
    values('Nicolau Vergueiro', 1);

insert
    into cidades(nome, id_estados)
    values('Nonoai', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Alvorada', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Araçá', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Bassano', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Boa Vista', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Bréscia', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Candelária', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Esperança do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Hartz', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Pádua', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Palma', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Petrópolis', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Prata', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Ramada', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Roma do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Nova Santa Rita', 1);

insert
    into cidades(nome, id_estados)
    values('Novo Barreiro', 1);

insert
    into cidades(nome, id_estados)
    values('Novo Cabrais', 1);

insert
    into cidades(nome, id_estados)
    values('Novo Hamburgo', 1);

insert
    into cidades(nome, id_estados)
    values('Novo Machado', 1);

insert
    into cidades(nome, id_estados)
    values('Novo Tiradentes', 1);

insert
    into cidades(nome, id_estados)
    values('Novo Xingu', 1);

insert
    into cidades(nome, id_estados)
    values('Osório', 1);

insert
    into cidades(nome, id_estados)
    values('Paim Filho', 1);

insert
    into cidades(nome, id_estados)
    values('Palmares do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Palmeira das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Palmitinho', 1);

insert
    into cidades(nome, id_estados)
    values('Panambi', 1);

insert
    into cidades(nome, id_estados)
    values('Pantano Grande', 1);

insert
    into cidades(nome, id_estados)
    values('Paraí', 1);

insert
    into cidades(nome, id_estados)
    values('Paraíso do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Pareci Novo', 1);

insert
    into cidades(nome, id_estados)
    values('Parobé', 1);

insert
    into cidades(nome, id_estados)
    values('Passa Sete', 1);

insert
    into cidades(nome, id_estados)
    values('Passo do Sobrado', 1);

insert
    into cidades(nome, id_estados)
    values('Passo Fundo', 1);

insert
    into cidades(nome, id_estados)
    values('Paulo Bento', 1);

insert
    into cidades(nome, id_estados)
    values('Paverama', 1);

insert
    into cidades(nome, id_estados)
    values('Pedras Altas', 1);

insert
    into cidades(nome, id_estados)
    values('Pedro Osório', 1);

insert
    into cidades(nome, id_estados)
    values('Pejuçara', 1);

insert
    into cidades(nome, id_estados)
    values('Pelotas', 1);

insert
    into cidades(nome, id_estados)
    values('Picada Café', 1);

insert
    into cidades(nome, id_estados)
    values('Pinhal', 1);

insert
    into cidades(nome, id_estados)
    values('Pinhal da Serra', 1);

insert
    into cidades(nome, id_estados)
    values('Pinhal Grande', 1);

insert
    into cidades(nome, id_estados)
    values('Pinheirinho do Vale', 1);

insert
    into cidades(nome, id_estados)
    values('Pinheiro Machado', 1);

insert
    into cidades(nome, id_estados)
    values('Pirapó', 1);

insert
    into cidades(nome, id_estados)
    values('Piratini', 1);

insert
    into cidades(nome, id_estados)
    values('Planalto', 1);

insert
    into cidades(nome, id_estados)
    values('Poço das Antas', 1);

insert
    into cidades(nome, id_estados)
    values('Pontão', 1);

insert
    into cidades(nome, id_estados)
    values('Ponte Preta', 1);

insert
    into cidades(nome, id_estados)
    values('Portão', 1);

insert
    into cidades(nome, id_estados)
    values('Porto Alegre', 1);

insert
    into cidades(nome, id_estados)
    values('Porto Lucena', 1);

insert
    into cidades(nome, id_estados)
    values('Porto Mauá', 1);

insert
    into cidades(nome, id_estados)
    values('Porto Vera Cruz', 1);

insert
    into cidades(nome, id_estados)
    values('Porto Xavier', 1);

insert
    into cidades(nome, id_estados)
    values('Pouso Novo', 1);

insert
    into cidades(nome, id_estados)
    values('Presidente Lucena', 1);

insert
    into cidades(nome, id_estados)
    values('Progresso', 1);

insert
    into cidades(nome, id_estados)
    values('Protásio Alves', 1);

insert
    into cidades(nome, id_estados)
    values('Putinga', 1);

insert
    into cidades(nome, id_estados)
    values('Quaraí', 1);

insert
    into cidades(nome, id_estados)
    values('Quatro Irmãos', 1);

insert
    into cidades(nome, id_estados)
    values('Quevedos', 1);

insert
    into cidades(nome, id_estados)
    values('Quinze de Novembro', 1);

insert
    into cidades(nome, id_estados)
    values('Redentora', 1);

insert
    into cidades(nome, id_estados)
    values('Relvado', 1);

insert
    into cidades(nome, id_estados)
    values('Restinga Seca', 1);

insert
    into cidades(nome, id_estados)
    values('Rio dos Índios', 1);

insert
    into cidades(nome, id_estados)
    values('Rio Grande', 1);

insert
    into cidades(nome, id_estados)
    values('Rio Pardo', 1);

insert
    into cidades(nome, id_estados)
    values('Riozinho', 1);

insert
    into cidades(nome, id_estados)
    values('Roca Sales', 1);

insert
    into cidades(nome, id_estados)
    values('Rodeio Bonito', 1);

insert
    into cidades(nome, id_estados)
    values('Rolador', 1);

insert
    into cidades(nome, id_estados)
    values('Rolante', 1);

insert
    into cidades(nome, id_estados)
    values('Ronda Alta', 1);

insert
    into cidades(nome, id_estados)
    values('Rondinha', 1);

insert
    into cidades(nome, id_estados)
    values('Roque Gonzales', 1);

insert
    into cidades(nome, id_estados)
    values('Rosário do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Sagrada Família', 1);

insert
    into cidades(nome, id_estados)
    values('Saldanha Marinho', 1);

insert
    into cidades(nome, id_estados)
    values('Salto do Jacuí', 1);

insert
    into cidades(nome, id_estados)
    values('Salvador das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Salvador do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Sananduva', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Bárbara do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Cecília do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Clara do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Cruz do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Margarida do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Maria', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Maria do Herval', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Rosa', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Tereza', 1);

insert
    into cidades(nome, id_estados)
    values('Santa Vitória do Palmar', 1);

insert
    into cidades(nome, id_estados)
    values('Santana da Boa Vista', 1);

insert
    into cidades(nome, id_estados)
    values('Santana do Livramento', 1);

insert
    into cidades(nome, id_estados)
    values('Santiago', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Ângelo', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Antônio da Patrulha', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Antônio das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Antônio do Palma', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Antônio do Planalto', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Augusto', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Cristo', 1);

insert
    into cidades(nome, id_estados)
    values('Santo Expedito do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São Borja', 1);

insert
    into cidades(nome, id_estados)
    values('São Domingos do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São Francisco de Assis', 1);

insert
    into cidades(nome, id_estados)
    values('São Francisco de Paula', 1);

insert
    into cidades(nome, id_estados)
    values('São Gabriel', 1);

insert
    into cidades(nome, id_estados)
    values('São Jerônimo', 1);

insert
    into cidades(nome, id_estados)
    values('São João da Urtiga', 1);

insert
    into cidades(nome, id_estados)
    values('São João do Polêsine', 1);

insert
    into cidades(nome, id_estados)
    values('São Jorge', 1);

insert
    into cidades(nome, id_estados)
    values('São José das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('São José do Herval', 1);

insert
    into cidades(nome, id_estados)
    values('São José do Hortêncio', 1);

insert
    into cidades(nome, id_estados)
    values('São José do Inhacorá', 1);

insert
    into cidades(nome, id_estados)
    values('São José do Norte', 1);

insert
    into cidades(nome, id_estados)
    values('São José do Ouro', 1);

insert
    into cidades(nome, id_estados)
    values('São José do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São José dos Ausentes', 1);

insert
    into cidades(nome, id_estados)
    values('São Leopoldo', 1);

insert
    into cidades(nome, id_estados)
    values('São Lourenço do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São Luiz Gonzaga', 1);

insert
    into cidades(nome, id_estados)
    values('São Marcos', 1);

insert
    into cidades(nome, id_estados)
    values('São Martinho', 1);

insert
    into cidades(nome, id_estados)
    values('São Martinho da Serra', 1);

insert
    into cidades(nome, id_estados)
    values('São Miguel das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('São Nicolau', 1);

insert
    into cidades(nome, id_estados)
    values('São Paulo das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('São Pedro da Serra', 1);

insert
    into cidades(nome, id_estados)
    values('São Pedro das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('São Pedro do Butiá', 1);

insert
    into cidades(nome, id_estados)
    values('São Pedro do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São Sebastião do Caí', 1);

insert
    into cidades(nome, id_estados)
    values('São Sepé', 1);

insert
    into cidades(nome, id_estados)
    values('São Valentim', 1);

insert
    into cidades(nome, id_estados)
    values('São Valentim do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São Valério do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('São Vendelino', 1);

insert
    into cidades(nome, id_estados)
    values('São Vicente do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Sapiranga', 1);

insert
    into cidades(nome, id_estados)
    values('Sapucaia do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Sarandi', 1);

insert
    into cidades(nome, id_estados)
    values('Seberi', 1);

insert
    into cidades(nome, id_estados)
    values('Sede Nova', 1);

insert
    into cidades(nome, id_estados)
    values('Segredo', 1);

insert
    into cidades(nome, id_estados)
    values('Selbach', 1);

insert
    into cidades(nome, id_estados)
    values('Senador Salgado Filho', 1);

insert
    into cidades(nome, id_estados)
    values('Sentinela do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Serafina Corrêa', 1);

insert
    into cidades(nome, id_estados)
    values('Sério', 1);

insert
    into cidades(nome, id_estados)
    values('Sertão', 1);

insert
    into cidades(nome, id_estados)
    values('Sertão Santana', 1);

insert
    into cidades(nome, id_estados)
    values('Sete de Setembro', 1);

insert
    into cidades(nome, id_estados)
    values('Severiano de Almeida', 1);

insert
    into cidades(nome, id_estados)
    values('Silveira Martins', 1);

insert
    into cidades(nome, id_estados)
    values('Sinimbu', 1);

insert
    into cidades(nome, id_estados)
    values('Sobradinho', 1);

insert
    into cidades(nome, id_estados)
    values('Soledade', 1);

insert
    into cidades(nome, id_estados)
    values('Tabaí', 1);

insert
    into cidades(nome, id_estados)
    values('Tapejara', 1);

insert
    into cidades(nome, id_estados)
    values('Tapera', 1);

insert
    into cidades(nome, id_estados)
    values('Tapes', 1);

insert
    into cidades(nome, id_estados)
    values('Taquara', 1);

insert
    into cidades(nome, id_estados)
    values('Taquari', 1);

insert
    into cidades(nome, id_estados)
    values('Taquaruçu do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Tavares', 1);

insert
    into cidades(nome, id_estados)
    values('Tenente Portela', 1);

insert
    into cidades(nome, id_estados)
    values('Terra de Areia', 1);

insert
    into cidades(nome, id_estados)
    values('Teutônia', 1);

insert
    into cidades(nome, id_estados)
    values('Tio Hugo', 1);

insert
    into cidades(nome, id_estados)
    values('Tiradentes do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Toropi', 1);

insert
    into cidades(nome, id_estados)
    values('Torres', 1);

insert
    into cidades(nome, id_estados)
    values('Tramandaí', 1);

insert
    into cidades(nome, id_estados)
    values('Travesseiro', 1);

insert
    into cidades(nome, id_estados)
    values('Três Arroios', 1);

insert
    into cidades(nome, id_estados)
    values('Três Cachoeiras', 1);

insert
    into cidades(nome, id_estados)
    values('Três Coroas', 1);

insert
    into cidades(nome, id_estados)
    values('Três de Maio', 1);

insert
    into cidades(nome, id_estados)
    values('Três Forquilhas', 1);

insert
    into cidades(nome, id_estados)
    values('Três Palmeiras', 1);

insert
    into cidades(nome, id_estados)
    values('Três Passos', 1);

insert
    into cidades(nome, id_estados)
    values('Trindade do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Triunfo', 1);

insert
    into cidades(nome, id_estados)
    values('Tucunduva', 1);

insert
    into cidades(nome, id_estados)
    values('Tunas', 1);

insert
    into cidades(nome, id_estados)
    values('Tupanci do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Tupanciretã', 1);

insert
    into cidades(nome, id_estados)
    values('Tupandi', 1);

insert
    into cidades(nome, id_estados)
    values('Tuparendi', 1);

insert
    into cidades(nome, id_estados)
    values('Turuçu', 1);

insert
    into cidades(nome, id_estados)
    values('Ubiretama', 1);

insert
    into cidades(nome, id_estados)
    values('União da Serra', 1);

insert
    into cidades(nome, id_estados)
    values('Unistalda', 1);

insert
    into cidades(nome, id_estados)
    values('Uruguaiana', 1);

insert
    into cidades(nome, id_estados)
    values('Vacaria', 1);

insert
    into cidades(nome, id_estados)
    values('Vale do Sol', 1);

insert
    into cidades(nome, id_estados)
    values('Vale Real', 1);

insert
    into cidades(nome, id_estados)
    values('Vale Verde', 1);

insert
    into cidades(nome, id_estados)
    values('Vanini', 1);

insert
    into cidades(nome, id_estados)
    values('Venâncio Aires', 1);

insert
    into cidades(nome, id_estados)
    values('Vera Cruz', 1);

insert
    into cidades(nome, id_estados)
    values('Veranópolis', 1);

insert
    into cidades(nome, id_estados)
    values('Vespasiano Correa', 1);

insert
    into cidades(nome, id_estados)
    values('Viadutos', 1);

insert
    into cidades(nome, id_estados)
    values('Viamão', 1);

insert
    into cidades(nome, id_estados)
    values('Vicente Dutra', 1);

insert
    into cidades(nome, id_estados)
    values('Victor Graeff', 1);

insert
    into cidades(nome, id_estados)
    values('Vila Flores', 1);

insert
    into cidades(nome, id_estados)
    values('Vila Lângaro', 1);

insert
    into cidades(nome, id_estados)
    values('Vila Maria', 1);

insert
    into cidades(nome, id_estados)
    values('Vila Nova do Sul', 1);

insert
    into cidades(nome, id_estados)
    values('Vista Alegre', 1);

insert
    into cidades(nome, id_estados)
    values('Vista Alegre do Prata', 1);

insert
    into cidades(nome, id_estados)
    values('Vista Gaúcha', 1);

insert
    into cidades(nome, id_estados)
    values('Vitória das Missões', 1);

insert
    into cidades(nome, id_estados)
    values('Westfalia', 1);

insert
    into cidades(nome, id_estados)
    values('Xangri-lá', 1);

insert
    into enderecos(rua, numero, complemento, bairro, id_cidades)
    values('Rua João da Silva Teste', 1, null, 'Centro', 326);

Update produtores
    set id_enderecos = 1
    where id = 1;