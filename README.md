# 👤 API CRUD de Usuários

API REST simples para gerenciamento de usuários, desenvolvida com Spring Boot e banco de dados H2 em memória.

---

## 🚀 Tecnologias

* **Java 21+**
* **Spring Boot**
* **Spring Data JPA**
* **H2 Database** (banco em memória)
* **Lombok**
* **Maven**

---

## 📁 Estrutura do Projeto

```bash
src/main/java/com/crud/api/
├── controller/
│   └── UsuarioController.java
├── service/
│   └── UsuarioService.java
├── repository/
│   └── UsuarioRepository.java
├── domain/
│   └── Usuario.java
├── dto/
│   └── UsuarioDTO.java
├── exception/
│   └── GlobalExceptionHandler.java
└── ApiApplication.java
```

---

## ⚙️ Como rodar o projeto

### Pré-requisitos

* Java 21+
* Maven

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/api-crud-usuarios.git

# Entre na pasta do projeto
cd api-crud-usuarios

# Rode o projeto
./mvnw spring-boot:run
```

A API estará disponível em:

```bash
http://localhost:8080
```

---

## 🗄️ Banco de Dados

O projeto utiliza o **H2 Database**, um banco em memória usado normalmente para testes e estudos.

Os dados são apagados sempre que a aplicação é reiniciada.

### Configuração do H2

```properties
spring.datasource.url=jdbc:h2:mem:usuario
spring.datasource.username=sa
spring.datasource.password=
```

### Acessando o console do H2

```bash
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:usuario
Username: sa
Password: (vazio)
```

---

## 📌 Endpoints

Base URL:

```bash
/usuario
```

---

### ✅ Cadastrar usuário

```http
POST /usuario
```

### Body

```json
{
  "email": "joao@email.com",
  "nome": "João Silva"
}
```

---

### 🔍 Buscar usuário por email

```http
GET /usuario?email=joao@email.com
```

### Retorno

```json
{
  "id": 1,
  "email": "joao@email.com",
  "nome": "João Silva"
}
```

---

### ✏️ Atualizar usuário por ID

```http
PUT /usuario?id=1
```

### Body

```json
{
  "email": "novoemail@email.com",
  "nome": "João Atualizado"
}
```

---

### ❌ Deletar usuário por email

```http
DELETE /usuario?email=joao@email.com
```

---

## 📋 Respostas HTTP

| Status            | Situação                              |
| ----------------- | ------------------------------------- |
| `200 OK`          | Operação realizada com sucesso        |
| `400 Bad Request` | Erro de validação ou regra de negócio |

---

## 🔒 Regras de Negócio

* Não é permitido cadastrar dois usuários com o mesmo email
* O email é único no banco de dados
* Na atualização, apenas os campos enviados são alterados
* Caso o email não exista na busca, retorna uma mensagem de erro
* Caso o ID não exista na atualização, retorna uma mensagem de erro

---

## ⚠️ Tratamento de Erros

Exemplos de mensagens retornadas pela API:

```json
"Email já cadastrado!"
```

```json
"Email nao encontrado"
```

```json
"Id nao encontrado"
```

---

## 🛠️ Melhorias Futuras

* [ ] Implementar autenticação com JWT
* [ ] Adicionar validações com Bean Validation (`@NotNull`, `@Email`, `@NotBlank`)
* [ ] Migrar para banco MySQL ou PostgreSQL
* [ ] Criar endpoint para listar todos os usuários
* [ ] Adicionar paginação
* [ ] Melhorar os status HTTP (`404`, `409`, `201`...)
* [ ] Adicionar documentação com Swagger/OpenAPI

---

## 📚 Objetivo do Projeto

Esse projeto foi desenvolvido com foco em aprendizado de:

* Criação de APIs REST com Spring Boot
* Organização de camadas (`controller`, `service`, `repository`)
* Integração com banco de dados usando JPA
* Uso do H2 Database
* Tratamento simples de erros
* Estruturação de projetos Java
