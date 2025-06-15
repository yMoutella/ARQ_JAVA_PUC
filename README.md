# ARQ_JAVA_PUC
Repositório de tarefas das aulas de Arquitetura JAVA

## O que foi feito

- Projeto Spring Boot para gerenciamento de alunos (CRUD).
- Tratamento de exceções personalizadas.
- Separação em camadas: controller, service, repository, entity e exceptions.
- Testes unitários.
- `.gitignore` configurado para evitar versionamento de arquivos de IDE e build.

## Como rodar o projeto

1. **Pré-requisitos:**  
   - Java 17+  
   - Maven 3.8+  
   - PostgreSQL rodando localmente

2. **Preparar o banco de dados:**  
   O projeto espera um banco PostgreSQL disponível em:
   - Host: `localhost`
   - Porta: `5432`
   - Banco: `postgres`
   - Usuário: `postgres`
   - Senha: `root`

   Essas configurações podem ser alteradas no arquivo `src/main/resources/application.properties`.

3. **Clonar o repositório e executar:**  
    ```bash
    git clone https://github.com/yMoutella/ARQ_JAVA_PUC.git
    cd ARQ_JAVA_PUC
    mvn clean install
    mvn spring-boot:run
    ```

O backend estará disponível em:  
`http://localhost:8080`

## Testando a API com Insomnia

1. Instale o Insomnia:  
   [https://insomnia.rest/download](https://insomnia.rest/download)

2. Crie requisições para os endpoints, por exemplo:
   - `GET http://localhost:8080/alunos`
   - `POST http://localhost:8080/alunos` (com JSON no body)
   - `DELETE http://localhost:8080/alunos/{id}`