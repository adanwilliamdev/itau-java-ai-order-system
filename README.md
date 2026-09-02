<div align="center">

# 🚀 Sistema de Processamento de Pedidos

### Itaú Java AI | Design Patterns & Spring AI

API REST para processamento de pedidos desenvolvida em **Java e Spring Boot**, aplicando padrões de projeto e recursos de Inteligência Artificial para processamento de comandos de voz.

[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=openjdk\&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge\&logo=springboot\&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-0.8.1-blue?style=for-the-badge)](https://spring.io/projects/spring-ai)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

</div>

---

## 📋 Sobre o Projeto

O **Sistema de Processamento de Pedidos** é uma API REST desenvolvida como parte do **Desafio Final do curso de Padrões de Projeto da DIO**, dentro do programa **Itaú Java AI**.

O projeto integra quatro padrões de projeto comportamentais para organizar diferentes responsabilidades da aplicação:

* 🔄 Gerenciamento do ciclo de vida dos pedidos
* ⛓️ Validações encadeadas
* 🚚 Estratégias de cálculo de frete
* 🔔 Sistema de notificações

Além disso, a aplicação possui integração com **Spring AI e OpenAI** para processamento de comandos de voz.

---

# ✨ Principais Funcionalidades

* 📦 Criação e gerenciamento de pedidos
* 🔄 Controle do ciclo de vida dos pedidos
* ⛓️ Validações encadeadas
* 🚚 Diferentes estratégias de frete
* 🔔 Notificações por múltiplos canais
* 🎙️ Processamento de comandos de voz
* 🧠 Identificação de intenção utilizando IA
* 📚 Documentação interativa com Swagger
* 💾 Persistência utilizando JPA/Hibernate
* 🗄️ Banco de dados H2 para desenvolvimento

---

# 🎯 Design Patterns Implementados

## 🔄 State Pattern

O padrão **State** é utilizado para representar e controlar os diferentes estados de um pedido.

### Ciclo de vida

```text
PENDENTE → PAGO → ENVIADO → ENTREGUE
```

Também existe suporte ao estado:

```text
CANCELADO
```

### Estados implementados

```text
state/
├── StatePedido.java
├── PendenteState.java
├── PagoState.java
├── EnviadoState.java
├── EntregueState.java
└── CanceladoState.java
```

### Benefício

Permite que o comportamento do pedido seja controlado de acordo com seu estado atual, evitando regras concentradas em grandes blocos de `if/else`.

---

## ⛓️ Chain of Responsibility

O padrão **Chain of Responsibility** é utilizado para organizar as validações do pedido em uma sequência de responsabilidades.

### Fluxo de validação

```text
Estoque
   ↓
Pagamento
   ↓
Frete
```

### Componentes

```text
chain/
├── ValidadorPedido.java
├── ValidadorEstoque.java
├── ValidadorPagamento.java
├── ValidadorFrete.java
└── ValidadorChainConfig.java
```

### Benefício

Cada validador possui uma responsabilidade específica e pode encaminhar o processamento para a próxima etapa da cadeia.

Isso facilita a manutenção e a inclusão de novas validações.

---

## 🚚 Strategy Pattern

O padrão **Strategy** permite utilizar diferentes estratégias para o cálculo do frete.

### Estratégias disponíveis

| Tipo                | Descrição                |
| ------------------- | ------------------------ |
| ⚡ Expresso          | Entrega em até 24 horas  |
| 🚚 Econômico        | Entrega entre 5 e 7 dias |
| 🏪 Retirada na Loja | Sem custo de frete       |

### Estrutura

```text
strategy/
├── CalculoFreteStrategy.java
├── FreteExpressoStrategy.java
├── FreteEconomicoStrategy.java
└── RetiradaLojaStrategy.java
```

### Benefício

Permite alterar o algoritmo utilizado para o cálculo do frete sem modificar a lógica principal do pedido.

---

## 👀 Observer Pattern

O padrão **Observer** é utilizado para implementar o sistema de notificações.

### Canais disponíveis

* 📧 Email
* 📱 SMS
* 🔔 Push

### Estrutura

```text
observer/
├── ObservadorPedido.java
├── NotificadorEmail.java
├── NotificadorSMS.java
└── NotificadorPush.java
```

### Benefício

Os observadores podem ser notificados automaticamente quando ocorre uma alteração relevante no pedido.

---

# 🤖 Inteligência Artificial e Comandos de Voz

A aplicação utiliza **Spring AI** integrado aos serviços da **OpenAI** para permitir a execução de comandos através de áudio.

## Funcionalidades

* 🎙️ Transcrição de áudio
* 🧠 Identificação da intenção do usuário
* ⚡ Processamento de comandos
* 📋 Registro das transações de voz

## Serviços de IA

```text
service/
└── ai/
    ├── AudioTranscriptionService.java
    └── VoiceIntentService.java
```

## Comandos suportados

| Comando           | Descrição                   |
| ----------------- | --------------------------- |
| `CRIAR_PEDIDO`    | Criar um novo pedido        |
| `CONSULTAR_SALDO` | Consultar saldo disponível  |
| `LISTAR_PEDIDOS`  | Listar pedidos              |
| `CANCELAR_PEDIDO` | Cancelar um pedido          |
| `AJUDA`           | Exibir comandos disponíveis |

---

# 🏗️ Arquitetura do Projeto

```text
src/
└── main/
    └── java/
        └── com/
            └── itau/
                └── order/
                    │
                    ├── OrderSystemApplication.java
                    │
                    ├── model/
                    │   ├── Cliente.java
                    │   ├── ItemPedido.java
                    │   ├── Pedido.java
                    │   └── TransacaoVoz.java
                    │
                    ├── enums/
                    │   ├── StatusPedido.java
                    │   └── TipoFrete.java
                    │
                    ├── state/
                    │   ├── StatePedido.java
                    │   ├── PendenteState.java
                    │   ├── PagoState.java
                    │   ├── EnviadoState.java
                    │   ├── EntregueState.java
                    │   └── CanceladoState.java
                    │
                    ├── chain/
                    │   ├── ValidadorPedido.java
                    │   ├── ValidadorEstoque.java
                    │   ├── ValidadorPagamento.java
                    │   ├── ValidadorFrete.java
                    │   └── ValidadorChainConfig.java
                    │
                    ├── strategy/
                    │   ├── CalculoFreteStrategy.java
                    │   ├── FreteExpressoStrategy.java
                    │   ├── FreteEconomicoStrategy.java
                    │   └── RetiradaLojaStrategy.java
                    │
                    ├── observer/
                    │   ├── ObservadorPedido.java
                    │   ├── NotificadorEmail.java
                    │   ├── NotificadorSMS.java
                    │   └── NotificadorPush.java
                    │
                    ├── service/
                    │   ├── EstoqueService.java
                    │   ├── PagamentoService.java
                    │   ├── PedidoService.java
                    │   │
                    │   └── ai/
                    │       ├── AudioTranscriptionService.java
                    │       └── VoiceIntentService.java
                    │
                    └── controller/
                        ├── PedidoController.java
                        └── VoiceController.java
```

---

# 🛠️ Tecnologias

| Tecnologia         | Versão | Finalidade                          |
| ------------------ | ------ | ----------------------------------- |
| Java               | 17     | Linguagem principal                 |
| Spring Boot        | 3.2.0  | Framework da aplicação              |
| Spring AI          | 0.8.1  | Integração com IA                   |
| OpenAI GPT-4o-mini | -      | Processamento de intenção           |
| OpenAI Whisper     | -      | Transcrição de áudio                |
| JPA / Hibernate    | -      | Persistência de dados               |
| H2 Database        | -      | Banco de dados para desenvolvimento |
| Lombok             | -      | Redução de boilerplate              |
| Swagger / OpenAPI  | 2.3.0  | Documentação da API                 |
| Maven              | -      | Gerenciamento de dependências       |

---

# 🚀 Como Executar

## Pré-requisitos

Antes de iniciar o projeto, certifique-se de possuir:

* ☕ JDK 17 ou superior
* 📦 Maven 3.6 ou superior
* 🔑 Chave da API da OpenAI para utilização dos recursos de IA

---

## 1. Clone o repositório

```bash
git clone https://github.com/adanwilliamdev/itau-java-ai-order-system.git
```

Entre na pasta do projeto:

```bash
cd itau-java-ai-order-system
```

---

## 2. Configure a OpenAI API Key

### Windows PowerShell

```powershell
$env:OPENAI_API_KEY="sua-chave-aqui"
```

### Linux / macOS

```bash
export OPENAI_API_KEY="sua-chave-aqui"
```

### application.properties

Também é possível configurar diretamente nas propriedades da aplicação:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

> ⚠️ Recomenda-se não armazenar chaves de API diretamente no repositório.

---

## 3. Compile o projeto

```bash
mvn clean compile
```

---

## 4. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

---

# 🔗 Endpoints da API

## 📦 Pedidos

| Método | Endpoint                           | Descrição            |
| ------ | ---------------------------------- | -------------------- |
| `POST` | `/api/pedidos`                     | Criar pedido         |
| `GET`  | `/api/pedidos`                     | Listar pedidos       |
| `GET`  | `/api/pedidos/{id}`                | Buscar pedido por ID |
| `PUT`  | `/api/pedidos/{id}/proximo-estado` | Avançar estado       |
| `PUT`  | `/api/pedidos/{id}/cancelar`       | Cancelar pedido      |

---

## Exemplo: Criar Pedido

### Requisição

```http
POST /api/pedidos
Content-Type: application/json
```

```json
{
  "cliente": {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com",
    "telefone": "1199999999",
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
    },
    {
      "produtoId": 2,
      "nomeProduto": "Mouse Logitech",
      "quantidade": 2,
      "precoUnitario": 150.0
    }
  ],
  "tipoFrete": "EXPRESSO",
  "observacoes": "Pedido de teste"
}
```

---

# 🎙️ API de Comandos de Voz

| Método | Endpoint             | Descrição                   |
| ------ | -------------------- | --------------------------- |
| `POST` | `/api/voz/processar` | Processar áudio             |
| `GET`  | `/api/voz/status`    | Consultar status do serviço |

---

## Exemplo: Processar Áudio

```bash
curl -X POST http://localhost:8080/api/voz/processar \
  -F "audio=@comando.wav" \
  -F "clienteId=1"
```

### Exemplo de resposta

```json
{
  "clienteId": 1,
  "textoTranscrito": "quero criar um novo pedido",
  "intencao": "CRIAR_PEDIDO",
  "mensagem": "Comando de criação de pedido recebido!",
  "acao": "PEDIDO_CRIADO",
  "status": "SUCESSO"
}
```

---

# 📊 Documentação

## Swagger UI

A documentação interativa da API pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

## H2 Console

Para desenvolvimento, o projeto utiliza o banco de dados H2 em memória.

```text
http://localhost:8080/h2-console
```

### Configuração padrão

| Campo    | Valor                 |
| -------- | --------------------- |
| JDBC URL | `jdbc:h2:mem:orderdb` |
| Username | `sa`                  |
| Password | Em branco             |

---

# 📈 Fluxo da Aplicação

```text
┌───────────────────────────────┐
│       RECEBER PEDIDO          │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│    VALIDAÇÕES DO PEDIDO       │
│ Chain of Responsibility       │
│                               │
│ Estoque → Pagamento → Frete   │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│      CÁLCULO DE FRETE         │
│          Strategy             │
│                               │
│ Expresso                      │
│ Econômico                     │
│ Retirada na Loja              │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│       CICLO DO PEDIDO         │
│            State              │
│                               │
│ PENDENTE → PAGO → ENVIADO     │
│             → ENTREGUE        │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│        NOTIFICAÇÕES           │
│           Observer            │
│                               │
│ Email • SMS • Push            │
└───────────────────────────────┘
```

---

# 🧪 Testes

Execute os testes automatizados utilizando:

```bash
mvn test
```

---

# 📝 Licença

Este projeto está distribuído sob a licença MIT.

Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

# 🙏 Agradecimentos

* **DIO - Digital Innovation One**
* **Itaú**
* **Professor Poiani**
* **OpenAI**

---

# 📧 Contato

<div align="center">

[![GitHub](https://img.shields.io/badge/GitHub-adanwilliamdev-181717?style=for-the-badge\&logo=github)](https://github.com/adanwilliamdev)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Adan%20William-0077B5?style=for-the-badge\&logo=linkedin\&logoColor=white)](https://linkedin.com/in/awosantos)

</div>

---

<div align="center">

### ⭐ Projeto desenvolvido para o Desafio Final do Itaú Java AI

**Java • Spring Boot • Spring AI • Design Patterns**

Made with ☕ and 💜

</div>
