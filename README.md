# Animalia
# 🐾 Cadastro de Animais

API REST desenvolvida com **Spring Boot** para fins de estudo, aplicando conceitos de arquitetura em camadas, orientação a objetos, polimorfismo e o padrão **Strategy**.

> **Autor:** Axel D. Lima

---

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- OpenAPI (Swagger)
- Liquibase
- Maven

---

## 📚 Funcionalidades

- Cadastro de Aves, Mamíferos e Répteis
- Atualização e consulta de registros
- Versionamento de banco com Liquibase
- Documentação automática com Swagger
- Tratamento global de exceções

---

## 📖 Documentação da API

Após iniciar a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🗄️ Banco de Dados

O projeto utiliza o **H2 Database** para desenvolvimento.

Console:

```
http://localhost:8080/h2-console
```

---

## ⚙️ Gerando o Script SQL

Para gerar o arquivo `create.sql` a partir das entidades JPA, descomente as propriedades abaixo no `application.properties`:

```properties
spring.jpa.properties.javax.persistence.schema-generation.create-source=metadata
spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
```

Inicie a aplicação e o arquivo **create.sql** será gerado automaticamente.

Após gerar o script, comente novamente essas propriedades.

---

## 🔄 Atualizando o Liquibase

1. Copie o conteúdo do `create.sql`;
2. Crie um novo arquivo em:

```
src/main/resources/db/changelog/sql
```

3. Adicione o cabeçalho:

```sql
--liquibase formatted sql

--changeset axel:001
```

4. Cole o script SQL.
5. Inclua o novo arquivo no `db.changelog-master.xml`.

---

## 📂 Arquitetura

O projeto utiliza o padrão **Strategy**, separando a regra de negócio de cada tipo de animal.

```text
Controller
     │
CadastroAnimalService
     │
 ├── AveService
 ├── MamiferoService
 └── ReptilService
```

---

> Projeto desenvolvido para estudo e prática das principais tecnologias do ecossistema Spring Boot.
