# Sistema de Processamento de Pedidos com Spring AI

## Sobre o Projeto
API que processa comandos de voz usando Spring AI e OpenAI.

## Tecnologias
- Java 17
- Spring Boot 3.2.0
- Spring AI
- OpenAI GPT-4o-mini
- Whisper (Speech-to-Text)
- JPA/Hibernate
- H2 Database

## Como Executar

### Configurar API Key
$env:OPENAI_API_KEY="sua-chave-aqui"

### Executar
mvn spring-boot:run

## Endpoints
- POST /api/voz/processar - Processar audio
- GET /api/pedidos - Listar pedidos

## Documentacao
- Swagger: http://localhost:8080/swagger-ui.html
- H2: http://localhost:8080/h2-console
