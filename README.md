# crudClient

Customer registration program

# URL Start Spring boot

https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=1.8&groupId=br.com.david.lavor&artifactId=crudClient&name=crudClient&description=Customer%20registration%20program&packageName=br.com.david.lavor.crudClient&dependencies=web,data-jpa,h2,security

# Architecture

-Technologies
spring boot -> 2.3.3
language -> Java 8
project -> Gradle Project
Packaging -> jar
Spring Web -> Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
spring data-jpa -> Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
H2 Database  -> Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.
Spring Security -> Highly customizable authentication and access-control framework for Spring applications.
MockMvc -> API test integration.

-Packages

dto -> Transactional objects Rest and database.
repository -> interface with database.
rest -> Implementation of the REST api.
security -> implementation of Spring security basic autentication.
service -> package relating to services.

# Execution

-CUSTOMER REGISTRATION API
Import comand curl in the Postman

----------------------------------------------------------------------
curl --location --request POST 'http://localhost:8080/client/add' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=FD71EB1F604C951D01E5E9CC67C1CBBF' \
--data-raw '{
    "nome": "asafe",
    "cpf": "001806653213",
    "endereco": "Rua piratininga"
}'
----------------------------------------------------------------------

-CLIENT QUERY API
Import comand curl in the Postman

------------------------------------------------------------------
curl --location --request GET 'http://localhost:8080/client/get' \
--header 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=FD71EB1F604C951D01E5E9CC67C1CBBF' \
--data-raw ''
------------------------------------------------------------------

# Docker

reference -> https://spring.io/guides/topicals/spring-boot-docker/

dockerfile at the root of the project.

-Commands in Windows O.S
-------------------------------------------------------------------
docker build --build-arg JAR_FILE=build/libs/*.jar -t myorg/myapp .
-------------------------------------------------------------------

-----------------------------
docker build -t myorg/myapp .
-----------------------------