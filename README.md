# Raízes

Melhorar a comunicação entre pequenos agricultores e consumidores.

[![CircleCI](https://circleci.com/gh/aceleradora-TW/Raizes/tree/master.svg?style=svg)](https://circleci.com/gh/aceleradora-TW/Raizes/tree/master)

## Dependências

- Java 11
- Postgres 9.5
- Node 12

### Configurando banco de dados local

Por padrão, a aplicação tentará conectar com um banco de dados Postgres ao iniciar. Veja o arquivo `src/main/resources/application-dev.yml` para saber qual usuário e senha será utilizado. 

Você precisará criar um banco de dados vazio antes de iniciar a aplicação. O nome do banco padrão é `raizes` (veja o arquivo de configuração mencionado anteriormente). Para criá-lo, execute:

```bash
sudo -u postgres psql -c 'CREATE DATABASE raizes'
```

## Executando a aplicação

Para inicar o servidor:

1.Para instalar as dependências do projeto:

```sh
npm install
```

2.Este comando utiliza o webpack para gerar arquivos css e js de deselvolvimento, localizados em
  `/src/main/resources/static/`.

```sh
npm run watch
```

2.1Assim como o watch este comando utiliza o webpack para gerar arquivos css e js localizados em
`/src/main/resources/static/`,porém agora os arquivos estarão otimizados para ambiente de produção.

```sh
npm run build
```

3.Para executar a aplicação e migrações do bando de dados:

```sh
./gradlew bootRun
```

O comando acima executará as migrações do banco de dados (que criarão as tabelas necessárias no banco de dados) antes de iniciar o servidor. 

Para saber quais alterações serão executadas no banco, veja os arquivos de migração em: `src/main/resources/db/migration`.


4.Executa `./gradlew bootRun` automaticamente:

```sh
./gradlew build --continuous
```

O comando compila o códico automaticamente a cada atualização. 

####Executando os testes:

```sh
./gradlew test
```

Demais comandos disponíveis:

```sh
./gradlew tasks
```

## Ferramentas

- [Circle CI](https://circleci.com/gh/aceleradora-TW/Raizes)


## Ambientes

__Integração__

Endereço: http://raizes-homologacao.herokuapp.com/

Este ambiente é atualizado toda vez que uma alteração é introduzida no projeto e as verificações automatizados do Circle CI executam exitosamente. Ou seja é o ambiente mais instável e que recebe as alterações mais recentes.

__Produção__

Endereço: http://raizes-producao.herokuapp.com/

Este ambiente é o onde será entregue versão final da aplicação.
