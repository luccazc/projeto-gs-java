Integrantes :
Lucca Calsolari RM: 553678 
Miguel Leal Tasso RM: 553009
João Victor RM: 553888


# Queimadas Monitoramento - API REST

## Descrição do Problema

As queimadas representam um dos maiores desafios ambientais do Brasil, com impactos negativos para o clima, fauna, flora, economia e saúde pública. O monitoramento eficiente dos focos de incêndio é fundamental para a atuação rápida e eficaz de agentes ambientais, prevenindo desastres maiores.

Este projeto propõe uma solução backend, utilizando Java e Spring Boot, para monitoramento de queimadas. A aplicação expõe uma API RESTful, permitindo o cadastro de sensores, regiões, agentes ambientais, registro de pontos de foco e alertas automáticos em caso de novos focos detectados.

---

## Arquitetura da Solução

- **Camadas Separadas:** Controller, Service, Repository e Domain.
- **Persistência:** Banco H2 em memória.
- **API REST:** Endpoints HTTP para CRUD de cada entidade.
- **Geração automática de alerta** ao registrar um novo ponto de foco.
- **Boas práticas de orientação a objetos**: encapsulamento, herança, polimorfismo (via relacionamentos JPA).
- **Padrões de projeto utilizados:** Repository e Builder.

**Principais entidades do domínio:**
- `Sensor`: Dispositivo que detecta calor ou fumaça.
- `Regiao`: Área monitorada.
- `PontoDeFoco`: Registro de foco detectado.
- `Alerta`: Notificação de incidente.
- `AgenteAmbiental`: Profissional responsável por intervenções.

---

## Instruções para Execução

1. **Pré-requisitos:**  
   - Java 17+  
   - Maven

2. **Como rodar o projeto:**
   ```bash
   mvn spring-boot:run
   
JDBC URL: jdbc:h2:mem:queimadasdb

Usuário: sa

Senha: (deixe em branco)
   
spring.application.name=queimadas-monitoramento
spring.datasource.url=jdbc:h2:mem:queimadasdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

# Porta padrão
server.port=8080
