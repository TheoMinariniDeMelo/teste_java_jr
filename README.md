# Coupon API

Teste técnico para a vaga de desenvolvedor Java.

Tecnologias utilizadas
- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger UI)


## Como executar

### 1ª forma: execute com docker

1 - build da imagem com docker

```shell
docker build -t cupom-api .
```
2 - subir o container

```shell
docker run -p 8080:8080 cupom-api
```
### 2ª forma: execute com gradle wrapper

1 - certifique de ter o java 21 instalado

```shell
java -version
```

2 - execute a aplicação com gradlew

```shell
./gradlew bootRun
```

### Documentação

```bash
http://localhost:8080/swagger-ui/index.html
```