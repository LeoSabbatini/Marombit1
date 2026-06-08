# Marombit
## Tecnologias Utilizadas

### Backend
![Java](https://img.shields.io/badge/Java-17+-orange?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-white?style=flat&logo=springboot)
![Spring Web](https://img.shields.io/badge/Spring_Web-white?style=flat&logo=spring)
![Lombok](https://img.shields.io/badge/Lombok-red?style=flat&logo=lombok)
![YAML Badge](https://img.shields.io/badge/YAML-8?style=flat&logo=yaml&logoColor=white)

### Banco de Dados
![MySQL](https://img.shields.io/badge/MySQL-8+-4479A1?style=flat&logo=mysql&logoColor=white)

---

## Funcionalidades

- CRUD completo alunos
- Verificar status da matricula por aluno
---
## Endpoints

Todos os endpoints estão sob o prefixo `/alunos`.

| Método | Rota                  | Descrição | Status de retorno |
|---|-----------------------|---|---|
| `GET` | `/alunos`             | Listar todos os alunos | `200 OK` |
| `GET` | `/alunos/{id}`        | Buscar aluno por ID | `200 OK` / `404 Not Found` |
| `POST` | `/alunos`             | Cadastrar novo aluno | `201 Created` |
| `PUT` | `/alunos/{id}`        | Atualizar dados do aluno | `200 OK` / `404 Not Found` |
| `DELETE` | `/alunos/{id}`        | Remover aluno | `204 No Content` / `404 Not Found` |
| `GET` | `/alunos/{id}/status` | Consultar status de matrícula | `200 OK` / `404 Not Found` |

---

## Como Rodar Localmente

### Pré-requisitos

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=flat&logo=apachemaven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8+-4479A1?style=flat&logo=mysql&logoColor=white)
![YAML Badge](https://img.shields.io/badge/YAML-8?style=flat&logo=yaml&logoColor=white)

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/LeoSabbatini/Marombit1
cd Marombit1
```

2. Configure o banco em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/marombit
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Execute:
```bash
mvn spring-boot:run
```

4. Acesse em `http://localhost:8080`

---



<div align="center">

Desenvolvido por

[![Leo](https://img.shields.io/badge/LeoSabbatini-181717?style=flat&logo=github&logoColor=white)](https://github.com/LeoSabbatini)

</div>