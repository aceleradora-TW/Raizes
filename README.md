# Esqueleto Ambulante

Uma aplicação mínima em Spring Boot.

[![CircleCI](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master.svg?style=svg)](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master)

![Caveira](./src/main/resources/static/images/sneaky.gif)


## Dependências

- Java 11
- Postgres 9.5

### Configurando banco de dados local

Por padrão, a aplicação tentará conectar com um banco de dados Postgres ao iniciar. Veja o arquivo `src/main/resources/application-dev.yml` para saber qual usuário e senha será utilizado. 

Você precisará criar um banco de dados vazio antes de iniciar a aplicação. O nome do banco padrão é `esqueleto` (veja o arquivo de configuração mencionado anteriormente). Para criá-lo, execute:

```bash
sudo -u postgres psql -c 'CREATE DATABASE esqueleto'
```

__Usando Postgres via Docker__

Caso não queira instalar o Postgres na sua máquina, é possível utilizá-lo via Docker:

Inicie o container em plano de fundo:

```bash
docker run --rm --name esqueleto-db -p 5432:5432 -e POSTGRES_PASSWORD=esqueleto -d postgres
```

Crie o banco de dados `esqueleto`:

```bash
docker exec -it esqueleto-db psql -U postgres -c 'CREATE DATABASE esqueleto'
```

## Executando a aplicação

Para inicar o servidor:

```sh
./gradlew bootRun
```

O comando acima executará as migrações do banco de dados (que criarão as tabelas necessárias no banco de dados) antes de iniciar o servidor. 

Para saber quais alterações serão executadas no banco, veja os arquivos de migração em: `src/main/resources/db/migration`

Executando os testes:

```sh
./gradlew test
```

Demais comandos disponíveis:

```sh
./gradlew tasks
```

## Ferramentas

- [Circle CI](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante)


## Ambientes

__Integração__

Endereço: https://esqueleto-integracao.herokuapp.com

Este ambiente é atualizado toda vez que uma alteração é introduzida no projeto e as verificações automatizados do Circle CI executam exitosamente. Ou seja é o ambiente mais instável e que recebe as alterações mais recentes.
