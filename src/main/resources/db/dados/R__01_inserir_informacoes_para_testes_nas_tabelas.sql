--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from listas_produtos;
delete from produtos_produtores;
delete from produtos;
delete from produtores;
delete from categorias;
delete from listas;
delete from clientes;
delete from usuarios;
delete from enderecos;
delete from cidades;
delete from estados;

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
  into estados(uf)
  values ('RS');

insert into cidades(nome, id_estados)
values('Aceguá', 1),
('Água Santa', 1),
('Agudo', 1),
('Ajuricaba', 1),
('Alecrim', 1),
('Alegrete', 1),
('Alegria', 1),
('Almirante Tamandaré do Sul', 1),
('Alpestre', 1),
('Alto Alegre', 1),
('Alto Feliz', 1),
('Alvorada', 1),
('Amaral Ferrador', 1),
('Ametista do Sul', 1),
('André da Rocha', 1),
('Anta Gorda', 1),
('Antônio Prado', 1),
('Arambaré', 1),
('Araricá', 1),
('Aratiba', 1),
('Arroio do Meio', 1),
('Arroio do Padre', 1),
('Arroio do Sal', 1),
('Arroio do Tigre', 1),
('Arroio dos Ratos', 1),
('Arroio Grande', 1),
('Arvorezinha', 1),
('Pinto Bandeira', 1),
('Augusto Pestana', 1),
('Áurea', 1),
('Bagé', 1),
('Balneário Pinhal', 1),
('Barão', 1),
('Barão de Cotegipe', 1),
('Barão do Triunfo', 1),
('Barra do Guarita', 1),
('Barra do Quaraí', 1),
('Barra do Ribeiro', 1),
('Barra do Rio Azul', 1),
('Barra Funda', 1),
('Barracão', 1),
('Barros Cassal', 1),
('Benjamin Constant do Sul', 1),
('Bento Gonçalves', 1),
('Boa Vista das Missões', 1),
('Boa Vista do Buricá', 1),
('Boa Vista do Cadeado', 1),
('Boa Vista do Incra', 1),
('Boa Vista do Sul', 1),
('Bom Jesus', 1),
('Bom Princípio', 1),
('Bom Progresso', 1),
('Bom Retiro do Sul', 1),
('Boqueirão do Leão', 1),
('Bossoroca', 1),
('Bozano', 1),
('Braga', 1),
('Brochier', 1),
('Butiá', 1),
('Caçapava do Sul', 1),
('Cacequi', 1),
('Cachoeira do Sul', 1),
('Cachoeirinha', 1),
('Cacique Doble', 1),
('Caibaté', 1),
('Caiçara', 1),
('Camaquã', 1),
('Camargo', 1),
('Cambará do Sul', 1),
('Campestre da Serra', 1),
('Campina das Missões', 1),
('Campinas do Sul', 1),
('Campo Bom', 1),
('Campo Novo', 1),
('Campos Borges', 1),
('Candelária', 1),
('Cândido Godói', 1),
('Candiota', 1),
('Canela', 1),
('Canguçu', 1),
('Canoas', 1),
('Canudos do Vale', 1),
('Capão Bonito do Sul', 1),
('Capão da Canoa', 1),
('Capão do Cipó', 1),
('Capão do Leão', 1),
('Capela de Santana', 1),
('Capitão', 1),
('Capivari do Sul', 1),
('Caraá', 1),
('Carazinho', 1),
('Carlos Barbosa', 1),
('Carlos Gomes', 1),
('Casca', 1),
('Caseiros', 1),
('Catuípe', 1),
('Caxias do Sul', 1),
('Centenário', 1),
('Cerrito', 1),
('Cerro Branco', 1),
('Cerro Grande', 1),
('Cerro Grande do Sul', 1),
('Cerro Largo', 1),
('Chapada', 1),
('Charqueadas', 1),
('Charrua', 1),
('Chiapetta', 1),
('Chuí', 1),
('Chuvisca', 1),
('Cidreira', 1),
('Ciríaco', 1),
('Colinas', 1),
('Colorado', 1),
('Condor', 1),
('Constantina', 1),
('Coqueiro Baixo', 1),
('Coqueiros do Sul', 1),
('Coronel Barros', 1),
('Coronel Bicaco', 1),
('Coronel Pilar', 1),
('Cotiporã', 1),
('Coxilha', 1),
('Crissiumal', 1),
('Cristal', 1),
('Cristal do Sul', 1),
('Cruz Alta', 1),
('Cruzaltense', 1),
('Cruzeiro do Sul', 1),
('David Canabarro', 1),
('Derrubadas', 1),
('Dezesseis de Novembro', 1),
('Dilermando de Aguiar', 1),
('Dois Irmãos', 1),
('Dois Irmãos das Missões', 1),
('Dois Lajeados', 1),
('Dom Feliciano', 1),
('Dom Pedrito', 1),
('Dom Pedro de Alcântara', 1),
('Dona Francisca', 1),
('Doutor Maurício Cardoso', 1),
('Doutor Ricardo', 1),
('Eldorado do Sul', 1),
('Encantado', 1),
('Encruzilhada do Sul', 1),
('Engenho Velho', 1),
('Entre Rios do Sul', 1),
('Entre-Ijuís', 1),
('Erebango', 1),
('Erechim', 1),
('Ernestina', 1),
('Erval Grande', 1),
('Erval Seco', 1),
('Esmeralda', 1),
('Esperança do Sul', 1),
('Espumoso', 1),
('Estação', 1),
('Estância Velha', 1),
('Esteio', 1),
('Estrela', 1),
('Estrela Velha', 1),
('Eugênio de Castro', 1),
('Fagundes Varela', 1),
('Farroupilha', 1),
('Faxinal do Soturno', 1),
('Faxinalzinho', 1),
('Fazenda Vilanova', 1),
('Feliz', 1),
('Flores da Cunha', 1),
('Floriano Peixoto', 1),
('Fontoura Xavier', 1),
('Formigueiro', 1),
('Forquetinha', 1),
('Fortaleza dos Valos', 1),
('Frederico Westphalen', 1),
('Garibaldi', 1),
('Garruchos', 1),
('Gaurama', 1),
('General Câmara', 1),
('Gentil', 1),
('Getúlio Vargas', 1),
('Giruá', 1),
('Glorinha', 1),
('Gramado', 1),
('Gramado dos Loureiros', 1),
('Gramado Xavier', 1),
('Gravataí', 1),
('Guabiju', 1),
('Guaíba', 1),
('Guaporé', 1),
('Guarani das Missões', 1),
('Harmonia', 1),
('Herval', 1),
('Herveiras', 1),
('Horizontina', 1),
('Hulha Negra', 1),
('Humaitá', 1),
('Ibarama', 1),
('Ibiaçá', 1),
('Ibiraiaras', 1),
('Ibirapuitã', 1),
('Ibirubá', 1),
('Igrejinha', 1),
('Ijuí', 1),
('Ilópolis', 1),
('Imbé', 1),
('Imigrante', 1),
('Independência', 1),
('Inhacorá', 1),
('Ipê', 1),
('Ipiranga do Sul', 1),
('Iraí', 1),
('Itaara', 1),
('Itacurubi', 1),
('Itapuca', 1),
('Itaqui', 1),
('Itati', 1),
('Itatiba do Sul', 1),
('Ivorá', 1),
('Ivoti', 1),
('Jaboticaba', 1),
('Jacuizinho', 1),
('Jacutinga', 1),
('Jaguarão', 1),
('Jaguari', 1),
('Jaquirana', 1),
('Jari', 1),
('Jóia', 1),
('Júlio de Castilhos', 1),
('Lagoa Bonita do Sul', 1),
('Lagoa dos Três Cantos', 1),
('Lagoa Vermelha', 1),
('Lagoão', 1),
('Lajeado', 1),
('Lajeado do Bugre', 1),
('Lavras do Sul', 1),
('Liberato Salzano', 1),
('Lindolfo Collor', 1),
('Linha Nova', 1),
('Maçambara', 1),
('Machadinho', 1),
('Mampituba', 1),
('Manoel Viana', 1),
('Maquiné', 1),
('Maratá', 1),
('Marau', 1),
('Marcelino Ramos', 1),
('Mariana Pimentel', 1),
('Mariano Moro', 1),
('Marques de Souza', 1),
('Mata', 1),
('Mato Castelhano', 1),
('Mato Leitão', 1),
('Mato Queimado', 1),
('Maximiliano de Almeida', 1),
('Minas do Leão', 1),
('Miraguaí', 1),
('Montauri', 1),
('Monte Alegre dos Campos', 1),
('Monte Belo do Sul', 1),
('Montenegro', 1),
('Mormaço', 1),
('Morrinhos do Sul', 1),
('Morro Redondo', 1),
('Morro Reuter', 1),
('Mostardas', 1),
('Muçum', 1),
('Muitos Capões', 1),
('Muliterno', 1),
('Não-Me-Toque', 1),
('Nicolau Vergueiro', 1),
('Nonoai', 1),
('Nova Alvorada', 1),
('Nova Araçá', 1),
('Nova Bassano', 1),
('Nova Boa Vista', 1),
('Nova Bréscia', 1),
('Nova Candelária', 1),
('Nova Esperança do Sul', 1),
('Nova Hartz', 1),
('Nova Pádua', 1),
('Nova Palma', 1),
('Nova Petrópolis', 1),
('Nova Prata', 1),
('Nova Ramada', 1),
('Nova Roma do Sul', 1),
('Nova Santa Rita', 1),
('Novo Barreiro', 1),
('Novo Cabrais', 1),
('Novo Hamburgo', 1),
('Novo Machado', 1),
('Novo Tiradentes', 1),
('Novo Xingu', 1),
('Osório', 1),
('Paim Filho', 1),
('Palmares do Sul', 1),
('Palmeira das Missões', 1),
('Palmitinho', 1),
('Panambi', 1),
('Pantano Grande', 1),
('Paraí', 1),
('Paraíso do Sul', 1),
('Pareci Novo', 1),
('Parobé', 1),
('Passa Sete', 1),
('Passo do Sobrado', 1),
('Passo Fundo', 1),
('Paulo Bento', 1),
('Paverama', 1),
('Pedras Altas', 1),
('Pedro Osório', 1),
('Pejuçara', 1),
('Pelotas', 1),
('Picada Café', 1),
('Pinhal', 1),
('Pinhal da Serra', 1),
('Pinhal Grande', 1),
('Pinheirinho do Vale', 1),
('Pinheiro Machado', 1),
('Pirapó', 1),
('Piratini', 1),
('Planalto', 1),
('Poço das Antas', 1),
('Pontão', 1),
('Ponte Preta', 1),
('Portão', 1),
('Porto Alegre', 1),
('Porto Lucena', 1),
('Porto Mauá', 1),
('Porto Vera Cruz', 1),
('Porto Xavier', 1),
('Pouso Novo', 1),
('Presidente Lucena', 1),
('Progresso', 1),
('Protásio Alves', 1),
('Putinga', 1),
('Quaraí', 1),
('Quatro Irmãos', 1),
('Quevedos', 1),
('Quinze de Novembro', 1),
('Redentora', 1),
('Relvado', 1),
('Restinga Seca', 1),
('Rio dos Índios', 1),
('Rio Grande', 1),
('Rio Pardo', 1),
('Riozinho', 1),
('Roca Sales', 1),
('Rodeio Bonito', 1),
('Rolador', 1),
('Rolante', 1),
('Ronda Alta', 1),
('Rondinha', 1),
('Roque Gonzales', 1),
('Rosário do Sul', 1),
('Sagrada Família', 1),
('Saldanha Marinho', 1),
('Salto do Jacuí', 1),
('Salvador das Missões', 1),
('Salvador do Sul', 1),
('Sananduva', 1),
('Santa Bárbara do Sul', 1),
('Santa Cecília do Sul', 1),
('Santa Clara do Sul', 1),
('Santa Cruz do Sul', 1),
('Santa Margarida do Sul', 1),
('Santa Maria', 1),
('Santa Maria do Herval', 1),
('Santa Rosa', 1),
('Santa Tereza', 1),
('Santa Vitória do Palmar', 1),
('Santana da Boa Vista', 1),
('Santana do Livramento', 1),
('Santiago', 1),
('Santo Ângelo', 1),
('Santo Antônio da Patrulha', 1),
('Santo Antônio das Missões', 1),
('Santo Antônio do Palma', 1),
('Santo Antônio do Planalto', 1),
('Santo Augusto', 1),
('Santo Cristo', 1),
('Santo Expedito do Sul', 1),
('São Borja', 1),
('São Domingos do Sul', 1),
('São Francisco de Assis', 1),
('São Francisco de Paula', 1),
('São Gabriel', 1),
('São Jerônimo', 1),
('São João da Urtiga', 1),
('São João do Polêsine', 1),
('São Jorge', 1),
('São José das Missões', 1),
('São José do Herval', 1),
('São José do Hortêncio', 1),
('São José do Inhacorá', 1),
('São José do Norte', 1),
('São José do Ouro', 1),
('São José do Sul', 1),
('São José dos Ausentes', 1),
('São Leopoldo', 1),
('São Lourenço do Sul', 1),
('São Luiz Gonzaga', 1),
('São Marcos', 1),
('São Martinho', 1),
('São Martinho da Serra', 1),
('São Miguel das Missões', 1),
('São Nicolau', 1),
('São Paulo das Missões', 1),
('São Pedro da Serra', 1),
('São Pedro das Missões', 1),
('São Pedro do Butiá', 1),
('São Pedro do Sul', 1),
('São Sebastião do Caí', 1),
('São Sepé', 1),
('São Valentim', 1),
('São Valentim do Sul', 1),
('São Valério do Sul', 1),
('São Vendelino', 1),
('São Vicente do Sul', 1),
('Sapiranga', 1),
('Sapucaia do Sul', 1),
('Sarandi', 1),
('Seberi', 1),
('Sede Nova', 1),
('Segredo', 1),
('Selbach', 1),
('Senador Salgado Filho', 1),
('Sentinela do Sul', 1),
('Serafina Corrêa', 1),
('Sério', 1),
('Sertão', 1),
('Sertão Santana', 1),
('Sete de Setembro', 1),
('Severiano de Almeida', 1),
('Silveira Martins', 1),
('Sinimbu', 1),
('Sobradinho', 1),
('Soledade', 1),
('Tabaí', 1),
('Tapejara', 1),
('Tapera', 1),
('Tapes', 1),
('Taquara', 1),
('Taquari', 1),
('Taquaruçu do Sul', 1),
('Tavares', 1),
('Tenente Portela', 1),
('Terra de Areia', 1),
('Teutônia', 1),
('Tio Hugo', 1),
('Tiradentes do Sul', 1),
('Toropi', 1),
('Torres', 1),
('Tramandaí', 1),
('Travesseiro', 1),
('Três Arroios', 1),
('Três Cachoeiras', 1),
('Três Coroas', 1),
('Três de Maio', 1),
('Três Forquilhas', 1),
('Três Palmeiras', 1),
('Três Passos', 1),
('Trindade do Sul', 1),
('Triunfo', 1),
('Tucunduva', 1),
('Tunas', 1),
('Tupanci do Sul', 1),
('Tupanciretã', 1),
('Tupandi', 1),
('Tuparendi', 1),
('Turuçu', 1),
('Ubiretama', 1),
('União da Serra', 1),
('Unistalda', 1),
('Uruguaiana', 1),
('Vacaria', 1),
('Vale do Sol', 1),
('Vale Real', 1),
('Vale Verde', 1),
('Vanini', 1),
('Venâncio Aires', 1),
('Vera Cruz', 1),
('Veranópolis', 1),
('Vespasiano Correa', 1),
('Viadutos', 1),
('Viamão', 1),
('Vicente Dutra', 1),
('Victor Graeff', 1),
('Vila Flores', 1),
('Vila Lângaro', 1),
('Vila Maria', 1),
('Vila Nova do Sul', 1),
('Vista Alegre', 1),
('Vista Alegre do Prata', 1),
('Vista Gaúcha', 1),
('Vitória das Missões', 1),
('Westfalia', 1),
('Xangri-lá', 1);

insert
    into enderecos(rua, numero, complemento, bairro, id_cidades)
    values('Rua João da Silva Teste', 1, null, 'Centro', 326);

insert
  into usuarios (email, senha, nome, contato, id_endereco, tipo_de_usuario)
    values ('email@produtor.com', 'senha', 'Produtor', '5555', 1, 'PRODUTOR'),
      ('email@cliente.com', 'senha', 'Cliente', '7777', 1, 'CLIENTE');

insert
  into categorias (nome)
  values ('Fruta'), ('Verdura');

insert
  into produtos (nome, id_categorias)
  values ('Banana', 1), ('Batata', 2), ('Abacate', 1), ('Beterraba', 2), ('Alface', 2);

insert
  into clientes (id)
  values (2);

insert
  into produtores (id, possui_transporte)
  values (1, true);


insert
  into produtos_produtores (id_produtores, id_produtos, preco, quantidade_estoque)
  values (1, 1, 3, 50), (1, 2, 4, 70), (1, 3, 3, 35);
