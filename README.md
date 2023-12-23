# Gerador de Aposta

Este é um projeto de um sistema de geração de apostas em loterias, dividido em dois módulos: `masterkey` e `userlottery`.

## Estrutura do Código

### Módulo `masterkey`

Este módulo contém a lógica principal para gerar e armazenar os números de apostas. Ele consiste nos seguintes componentes principais:

- **`LotteryController`**: Controlador REST para gerar números de loteria e recuperar todos os números gerados.
- **`LotteryNumService`**: Serviço responsável por gerar e recuperar os números de loteria.
- **`LotteryNumbersResponse`**: Entidade que representa os números de loteria gerados.

### Módulo `userlottery`

Este módulo lida com as interações do usuário, incluindo a criação de usuários, autenticação e criação de bilhetes de loteria. Os principais componentes são:

- **`AuthUserControllers`**: Controlador responsável pela autenticação do usuário.
- **`TicketController`**: Controlador para criar bilhetes de loteria com diferentes quantidades de números.
- **`UserController`**: Controlador para criar usuários.

## Configurações necessárias

Para executar este projeto, siga as instruções abaixo:

### 1. Configuração do Banco de Dados

Certifique-se de criar um arquivo `application.properties` em cada um dos módulos, `masterkey` e `userlottery`, com as configurações do banco de dados. Aqui está um exemplo de configuração para o banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome-do-banco
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update.

Docker-compose.yml
version: '3.8'

services:
  db:
    image: postgres
    container_name: postgres-container
    ports:
      - "5432:5432"
    environment:
      POSTGRES_DB: nome-do-banco
      POSTGRES_USER: seu-usuario
      POSTGRES_PASSWORD: sua-senha


