# Spring Crud

Spring Boot application for CRUD to Sellers and Clients

**To run the Spring application:**
` mvn spring-boot:run `

**To run unit tests:**
` mvn test `

**Base URL:**
```
 http://localhost:8080/
 [HEADER] Content-Type: application/json
```
### Clients CRUD

- **List**
```
[GET] api/client
```

- **List Client with Sellers**
```
[GET] api/client/seller
```

- **Show client**
```
[GET] api/client/{Integer id}
```

- **Create**
```
[POST] api/client
[BODY] {
	"name": String,
	"cpf": String,
	"gender": String,
  "seller" {
    "id": Integer
  }
}
```

- **Update**
```
[PUT] api/client/{Integer id}
[BODY] {
	"name": String,
	"cpf": String,
	"gender": String,
  "seller" {
    "id": Integer
  }
}
```
- **Delete**
```
[DELETE] api/client/{Integer id}
```

### Sellers CRUD

- **List**
```
[GET] api/seller
```

- **List Clients from Seller**
```
[GET] api/seller/{Integer id}
```

- **Show seller**
```
[GET] api/seller/{Integer id}
```

- **Create**
```
[POST] api/seller
[BODY] {
	"name": String,
	"cpf": String
}
```

- **Update**
```
[PUT] api/seller/{Integer id}
[BODY] {
	"name": String,
	"cpf": String
}
```
- **Delete**
```
[DELETE] api/seller/{Integer id}
```

[GuilhermeFGL](https://www.linkedin.com/in/guilherme-faria-da-gama-lima-37baa647/)
