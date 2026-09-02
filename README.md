# 🚀 Sistema de Processamento de Pedidos

### Desafio Final | Itaú Java AI

Sistema de processamento de pedidos desenvolvido em **Java + Spring Boot**, criado como projeto final do curso de **Padrões de Projeto (Design Patterns)** da formação Itaú Java AI.

O projeto aplica padrões de projeto clássicos de forma integrada, simulando o ciclo completo de processamento de um pedido, desde sua criação até a entrega.

---

## 📋 Sobre o Projeto

A aplicação foi desenvolvida com foco na aplicação prática de **Design Patterns**, utilizando uma arquitetura organizada e extensível para representar diferentes responsabilidades do processo de pedidos.

O fluxo principal contempla:

```text
PENDENTE → PAGO → ENVIADO → ENTREGUE
```

Durante o processamento, o sistema realiza validações, calcula o frete de acordo com a estratégia escolhida e dispara notificações para o cliente.

---

## 🎯 Design Patterns Aplicados

### 🔄 State

Utilizado para gerenciar o **ciclo de vida do pedido**, permitindo controlar as transições entre seus diferentes estados.

```text
PENDENTE
   ↓
PAGO
   ↓
ENVIADO
   ↓
ENTREGUE
```

Também permite o tratamento de operações específicas de acordo com o estado atual do pedido.

---

### ⛓️ Chain of Responsibility

Utilizado para implementar uma cadeia de validações antes do processamento do pedido.

```text
Estoque
   ↓
Pagamento
   ↓
Frete
   ↓
Pedido processado
```

Cada etapa é responsável por uma validação específica, mantendo as responsabilidades desacopladas.

---

### 🚚 Strategy

Utilizado para permitir diferentes estratégias de cálculo de frete sem alterar a lógica principal do pedido.

Estratégias implementadas:

* ⚡ **Expresso**
* 📦 **Econômico**
* 🏪 **Retirada na Loja**

A estratégia pode ser selecionada de acordo com o tipo de frete informado no pedido.

---

### 👀 Observer

Utilizado para implementar o sistema de notificações.

Canais disponíveis:

* 📧 Email
* 📱 SMS
* 🔔 Push

Quando ocorre um evento relevante no pedido, os observadores interessados são notificados automaticamente.

---

## 🏗️ Estrutura do Projeto

```text
src/
└── main/
    └── java/
        └── com/
            └── itau/
                └── order/
                    ├── model/        # Entidades do sistema
                    ├── enums/        # Enumerações
                    ├── state/        # Padrão State
                    ├── chain/        # Chain of Responsibility
                    ├── strategy/     # Padrão Strategy
                    ├── observer/     # Padrão Observer
                    ├── service/      # Regras de negócio
                    └── controller/   # Endpoints REST
```

---

## 🛠️ Tecnologias

| Tecnologia           | Versão |
| -------------------- | ------ |
| ☕ Java               | 17     |
| 🍃 Spring Boot       | 3.2.0  |
| 📦 Maven             | 3.6+   |
| 🛠️ Lombok           | —      |
| 📚 Swagger / OpenAPI | —      |

---

## 🚀 Como Executar

### Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

* **JDK 17 ou superior**
* **Maven 3.6 ou superior**
* IDE de sua preferência, como IntelliJ IDEA, Eclipse ou VS Code

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

### 2. Acesse o diretório

```bash
cd itau-java-ai-order-system
```

### 3. Compile o projeto

```bash
mvn clean install
```

### 4. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível na porta configurada pelo Spring Boot.

---

## 📡 API REST

### Criar Pedido

```http
POST /api/pedidos
```

#### Exemplo de requisição

```json
{
  "cliente": {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com",
    "preferenciasNotificacao": [
      "EMAIL",
      "SMS"
    ]
  },
  "itens": [
    {
      "produtoId": 1,
      "nomeProduto": "Notebook Dell",
      "quantidade": 1,
      "precoUnitario": 4500.0
    }
  ],
  "tipoFrete": "EXPRESSO"
}
```

---

## 🔗 Endpoints

| Método | Endpoint                           | Descrição                |
| ------ | ---------------------------------- | ------------------------ |
| `POST` | `/api/pedidos`                     | Criar pedido             |
| `PUT`  | `/api/pedidos/{id}/proximo-estado` | Avançar estado do pedido |
| `PUT`  | `/api/pedidos/{id}/cancelar`       | Cancelar pedido          |
| `GET`  | `/api/pedidos`                     | Listar pedidos           |
| `GET`  | `/api/pedidos/{id}`                | Buscar pedido por ID     |

---

## 🔄 Fluxo de Processamento

O processamento de um pedido combina os padrões implementados em diferentes etapas:

```text
                    ┌──────────────────┐
                    │   Criar Pedido   │
                    └────────┬─────────┘
                             ↓
                    ┌──────────────────┐
                    │     PENDENTE     │
                    └────────┬─────────┘
                             ↓
                  ┌──────────────────────┐
                  │ Chain of Responsibility │
                  └──────────┬───────────┘
                             ↓
                 ┌────────────────────────┐
                 │  Estoque → Pagamento  │
                 │        → Frete        │
                 └───────────┬────────────┘
                             ↓
                    ┌──────────────────┐
                    │      PAGO        │
                    └────────┬─────────┘
                             ↓
                    ┌──────────────────┐
                    │     ENVIADO      │
                    └────────┬─────────┘
                             ↓
                    ┌──────────────────┐
                    │    ENTREGUE      │
                    └──────────────────┘
                             │
                             ↓
                 ┌────────────────────────┐
                 │       Observer         │
                 │ Email • SMS • Push     │
                 └────────────────────────┘
```

O cálculo do frete é realizado utilizando o padrão **Strategy**, permitindo trocar a implementação sem modificar o fluxo principal.

---

## 📚 Conceitos Demonstrados

Este projeto demonstra conhecimentos em:

* Programação Orientada a Objetos
* Design Patterns
* Princípios SOLID
* Separação de responsabilidades
* Arquitetura em camadas
* Desenvolvimento de APIs REST
* Injeção de Dependências
* Encapsulamento
* Enumerações
* Tratamento de estados
* Validação de regras de negócio
* Comunicação entre componentes
* Documentação de APIs

---

## 📖 Documentação da API

A API possui integração com **Swagger/OpenAPI**, permitindo visualizar e testar os endpoints diretamente pelo navegador.

Após iniciar a aplicação, acesse a rota de documentação configurada no projeto.

---

## 🎓 Objetivo do Projeto

O principal objetivo foi transformar conceitos teóricos de **Design Patterns** em uma aplicação prática, demonstrando como diferentes padrões podem trabalhar juntos para criar um sistema mais:

* 🔧 **Manutenível**
* 📈 **Extensível**
* 🧩 **Modular**
* 🧪 **Testável**
* 📐 **Organizado**

---

## 👨‍💻 Desenvolvimento

Projeto desenvolvido como parte do **Desafio Final do Itaú Java AI**, com foco no desenvolvimento backend utilizando Java e Spring Boot.

---

<div align="center">

### 🚀 Java • Spring Boot • Design Patterns

**Desenvolvido com foco em boas práticas e evolução contínua em Backend Java.**

</div>
