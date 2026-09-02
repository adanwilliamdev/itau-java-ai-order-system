# 🚀 Sistema de Processamento de Pedidos

### Desafio Final | Itaú Java AI

Sistema de processamento de pedidos desenvolvido em **Java e Spring Boot** como parte do desafio final do curso de **Padrões de Projeto (Design Patterns)**.

O projeto foi desenvolvido com o objetivo de aplicar, de forma prática e integrada, diferentes padrões de projeto no desenvolvimento de uma aplicação de processamento de pedidos.

---

## 📋 Sobre o Projeto

A aplicação representa um sistema de processamento de pedidos, utilizando diferentes **Design Patterns** para organizar o gerenciamento de estados, validações, cálculo de frete e notificações.

O ciclo de vida do pedido é representado pelos seguintes estados:

```text
PENDENTE → PAGO → ENVIADO → ENTREGUE
```

---

## 🎯 Design Patterns Aplicados

### 🔄 State

O padrão **State** é utilizado para representar e gerenciar os diferentes estados do pedido.

Estados utilizados:

```text
PENDENTE
   ↓
PAGO
   ↓
ENVIADO
   ↓
ENTREGUE
```

Cada estado representa uma etapa diferente do ciclo de vida do pedido.

---

### ⛓️ Chain of Responsibility

O padrão **Chain of Responsibility** é utilizado para organizar as validações do processamento do pedido em uma cadeia.

Validações:

```text
Estoque → Pagamento → Frete
```

Cada etapa da cadeia é responsável por realizar sua respectiva validação antes que o processamento avance.

---

### 🚚 Strategy

O padrão **Strategy** é utilizado para definir diferentes estratégias para o cálculo do frete.

Estratégias disponíveis:

* ⚡ Expresso
* 📦 Econômico
* 🏪 Retirada na Loja

A estratégia de frete é definida de acordo com o tipo escolhido para o pedido.

---

### 👀 Observer

O padrão **Observer** é utilizado para o sistema de notificações.

Canais de notificação disponíveis:

* 📧 Email
* 📱 SMS
* 🔔 Push

O padrão permite que diferentes mecanismos de notificação sejam acionados quando ocorre uma alteração relevante no pedido.

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
                    ├── state/        # Implementação do State
                    ├── chain/        # Implementação do Chain of Responsibility
                    ├── strategy/     # Implementação do Strategy
                    ├── observer/     # Implementação do Observer
                    ├── service/      # Serviços da aplicação
                    └── controller/   # Endpoints REST
```

---

## 🛠️ Tecnologias

* ☕ **Java 17**
* 🍃 **Spring Boot 3.2.0**
* 📦 **Maven**
* 🛠️ **Lombok**
* 📚 **Swagger / OpenAPI**

---

## 🚀 Como Executar

### Pré-requisitos

* **JDK 17 ou superior**
* **Maven 3.6 ou superior**

### Executando o projeto

Clone o repositório e acesse a pasta do projeto:

```bash
cd C:\Dev\Projetos\itau-java-ai-order-system
```

Compile o projeto:

```bash
mvn clean install
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

---

## 📡 Exemplo de Uso

### Criar Pedido

**POST**

```text
/api/pedidos
```

### Requisição

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

| Método | Endpoint                           | Descrição                     |
| ------ | ---------------------------------- | ----------------------------- |
| `POST` | `/api/pedidos`                     | Criar pedido                  |
| `PUT`  | `/api/pedidos/{id}/proximo-estado` | Avançar para o próximo estado |
| `PUT`  | `/api/pedidos/{id}/cancelar`       | Cancelar pedido               |
| `GET`  | `/api/pedidos`                     | Listar pedidos                |
| `GET`  | `/api/pedidos/{id}`                | Buscar pedido por ID          |

---

## 📚 Documentação da API

O projeto utiliza **Swagger/OpenAPI** para documentação e teste dos endpoints da API REST.

Após iniciar a aplicação, a documentação pode ser acessada pela interface do Swagger configurada no projeto.

---

## 🎓 Objetivo

Este projeto foi desenvolvido como **Desafio Final do Itaú Java AI**, com foco na aplicação prática dos conceitos de **Design Patterns em Java**.

Os padrões utilizados são:

* **State** para gerenciamento dos estados do pedido;
* **Chain of Responsibility** para validações;
* **Strategy** para estratégias de cálculo de frete;
* **Observer** para notificações.

---

<div align="center">

### 🚀 Java • Spring Boot • Design Patterns

**Desenvolvido como projeto final do Itaú Java AI.**

</div>
