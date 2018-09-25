# Esqueleto Ambulante

Uma aplicação mínima em Spring Boot.

[![CircleCI](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master.svg?style=svg)](https://circleci.com/gh/aceleradora-TW/esqueleto-ambulante/tree/master)

## Dependências

- Java 8
- Postgres
- Node/npm

## Configuração inicial

Após instalar todas as dependências, execute as migrações do banco de dados:

```bash
./gradlew flywayMigrate -i
```

## Comandos

Para executar a aplicação:

```sh
./gradlew bootRun
```

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

Este ambiente é atualizado toda vez que uma alteração é introduzida no projeto e as verificações automatizados do Circle CI executam
exitosamente. Ou seja é o ambiente mais instável e que recebe as alterações mais recentes.
