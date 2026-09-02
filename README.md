# 🚀 Sistema de Processamento de Pedidos - Itaú Java AI

## 📋 Sobre o Projeto
Este projeto foi desenvolvido como parte do desafio final do curso de Padrões de Projeto (Design Patterns), aplicando os principais padrões de forma prática e integrada em um sistema de processamento de pedidos.

## 🎯 Padrões de Projeto Aplicados

### 1. **State** - Gerenciamento do Ciclo de Vida
Gerencia os estados do pedido: PENDENTE → PAGO → ENVIADO → ENTREGUE

### 2. **Chain of Responsibility** - Validações
Validações encadeadas: Estoque → Pagamento → Frete

### 3. **Strategy** - Cálculo de Frete
Estratégias: Expresso, Econômico e Retirada na Loja

### 4. **Observer** - Notificações
Notificações: Email, SMS e Push

## 🏗️ Estrutura do Projeto
\\\
src/main/java/com/itau/order/
├── model/         # Entidades do sistema
├── enums/         # Enumerações
├── state/         # Padrão State
├── chain/         # Padrão Chain of Responsibility
├── strategy/      # Padrão Strategy
├── observer/      # Padrão Observer
├── service/       # Serviços
└── controller/    # Endpoints REST
\\\

## 🚀 Como Executar

### Pré-requisitos
- JDK 17+
- Maven 3.6+

### Passos
\\\ash
# Navegar até o projeto
cd C:\Dev\Projetos\itau-java-ai-order-system

# Compilar e executar
mvn clean install
mvn spring-boot:run
\\\

## 📝 Exemplo de Uso
\\\json
POST /api/pedidos
{
  "cliente": {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com",
    "preferenciasNotificacao": ["EMAIL", "SMS"]
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
\\\

## 🔗 Endpoints
- \POST /api/pedidos\ - Criar pedido
- \PUT /api/pedidos/{id}/proximo-estado\ - Avançar estado
- \PUT /api/pedidos/{id}/cancelar\ - Cancelar pedido
- \GET /api/pedidos\ - Listar pedidos
- \GET /api/pedidos/{id}\ - Buscar pedido

## 🛠️ Tecnologias
- Java 17
- Spring Boot 3.2.0
- Maven
- Lombok
- Swagger/OpenAPI

---
**Desenvolvido para o Desafio Final - Itaú Java AI**
