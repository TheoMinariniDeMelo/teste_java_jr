# Coupon API

Uma api para gerenciar cupons de desconto

Tecnologias utilizadas
- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger UI)


## Como executar

### 1ª forma: execute com docker

builde a imagem com docker

```shell
  docker build -t cupom-api .
```
rode o container

```shell
  docker run -p 8080:8080 cupom-api
```
### 2ª forma: execute com gradle wrapper

```shell
    ./gradlew bootRun
```

### Documentação

```bash
http://localhost:8080/swagger-ui/index.html
```