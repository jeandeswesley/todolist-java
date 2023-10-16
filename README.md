# Backend do projeto Todo List - Curso Java Rocketseat

## 💻  Tecnologias

- [SpringBoot](https://spring.io/projects/spring-boot) v3.1.4
- [Maven](https://maven.apache.org/download.cgi)
- [Java 17](https://www.java.com/pt-BR/download/help/index_installing.html)
- [Postman](https://www.postman.com/)
- Bibliotecas:
    - [H2 - Databse Engine](https://www.h2database.com/html/main.html)
    - [BCrypt](https://github.com/patrickfav/bcrypt)
    - [Lombok](https://projectlombok.org/)

## Instalação

- [Git](https://github.com/jeandeswesley/todolist-java)

## 💻 Projeto

- Backend da aplicação de um gerenciador de tarefas, onde o usuário pode realizar:
    - Cadastro de usuário contendo: Nome, Usuário, Password
    - Cadastro de tarefas: Título, Descrição, Data Início, Data Final, Prioridade

- Implementado validações:
    - Valida usuário duplicado
    - Valida Uma tarefa nao pode ser criada com data inicio menor que a data atual
    - Valida uma tarefa nao pode ser criada coda data final menor que a data inicial
    - Valida campo descrição nao pode exceder mais que 50 caracteres
    - Valida não permite alterar tarefa com id inexistente
    - Valida usuário não tem permissão de alterar tarefa de outro usuário
