# Spring Boot - MongoDB - Docker - Swagger - Customer POC
Este projeto demonstra a integração do Spring Data com o MongoDB.

## MongoDB
Neste exemplo foi utilizado o MongoDB com Docker. Para configurar o ambiente, acesse o link abaixo.  
[MongoDB Docker Ubuntu](http://maxidica.com/wp/mongodb-docker-ubuntu/)  

## POST
URI: http://localhost:8080/customer  
Method: POST  
Body: JSON (application/json) - raw  
JSON:  
```
{
  "email": "john@com.com",
  "name": "John Baker",
  "address": [
    {
      "address": "Avenida Paulista",
      "number": "2300",
      "complement": "4 andar",
      "zipCode": "01311-000"
    },
    {
      "address": "Alameda Xingu",
      "number": "512",
      "complement": "25 andar",
      "zipCode": "06455-914"
    }
  ]
}
```  

## PUT
URI: http://localhost:8080/customer  
Method: PUT  
Body: JSON (application/json) - raw  
JSON:  
```
{
  "id": "5c2e84ceaa60850bb2469e92",
  "email": "john@com.com",
  "name": "John Baker",
  "address": [
    {
      "address": "Avenida Paulista",
      "number": "2300",
      "complement": "4 andar",
      "zipCode": "01311-000"
    },
    {
      "address": "Alameda Xingu",
      "number": "512",
      "complement": "25 andar",
      "zipCode": "06455-914"
    }
  ]
}
```  

## GET
URI: [http://localhost:8080/customer](http://localhost:8080/customer)  
Method: GET  

## GET BY NAME
URI: http://localhost:8080/customer/baker/name  
Method: GET 

## DELETE
URI: http://localhost:8080/customer/5c2e84ceaa60850bb2469e92  
Method: DELETE  

## Swagger UI
URI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
  
  
## MongoDB - Create User
### Rodando a imagem Docker
Digite o comando:  

```
sudo docker run --name testemongo -p 27017:27017 -d mongo
```

### Entrar no Docker
```
sudo docker exec -it testemongo /bin/bash
```
### Subindo o console do MongoDB
Utilizando Docker, digite o comando:  

```
root@925d56e0031d:/# mongo
```

### Script para criar usuário do banco
```
db.createUser(
   {
     user: "root",
     pwd: "root",
     roles: [ { role: "userAdmin", db: "spring_mongo_customer" } ],
     mechanisms: [ "SCRAM-SHA-1" ]
   }
)
```