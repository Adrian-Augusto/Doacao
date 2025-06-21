# Projeto Site de Doação - Microserviços

Este projeto é uma arquitetura baseada em microserviços para um site de doação, onde cada serviço é responsável por uma funcionalidade específica.

## Serviços principais

- **AuthService**: Autenticação e autorização de usuários (login, JWT, segurança).
- **UserService**: Gerenciamento de usuários (cadastro, perfil, roles).
- **DonationService**: Cadastro e gerenciamento das doações.
- **NotificationService**: Envio de notificações (email, push).
- **Gateway API**: Roteamento e balanceamento das chamadas para os microserviços.

## Tecnologias usadas

- Java 17 + Spring Boot (cada microserviço)
- Spring Cloud Gateway (API Gateway)
- Spring Security + JWT (segurança)
- Eureka Server / Consul (service discovery)
- RabbitMQ / Kafka (mensageria e eventos)
- Docker + Docker Compose (containerização)
- Banco de dados (MySQL, MongoDB, Redis dependendo do serviço)
