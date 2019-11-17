# Kotlin version of a Basic Spring Boot Application [![Build Status](https://travis-ci.org/spring-petclinic/spring-petclinic-kotlin.png?branch=master)](https://travis-ci.org/spring-petclinic/spring-petclinic-kotlin/)

This is sample [Spring Boot](https://spring.io/projects/spring-boot) Application written in [Kotlin](https://kotlinlang.org/) 
language. And this codebase was developed for demonstrating the seamless interoperability between Kotlin and Java.

## Technologies used

* Language: Kotlin
* Core framework: Spring Boot 2.2.1
* Persistence : Spring Data JPA
* Databases: H2
* Build: Maven

## Running Application locally

### With Maven command line

Clone this repository using following url
```
git clone https://github.com/sam-rajan/kotlin-spring-boot-todolist.git
```
Navigate to the project folder and execute the following command
```
./mvnw spring-boot:run
```
If you want to build with the regular `mvn` command, you will need
[Maven v3.5.0 or above](https://maven.apache.org/run-maven/index.html).

NOTE: You may need to increase the amount of memory available to Maven by setting
a `MAVEN_OPTS` environment variable with the value `-Xmx512m`. Remember
to set the corresponding property in your IDE as well if you are building and running
tests there. This property
is automatically set if you use the maven wrapper.

You can access application using: [http://localhost:8080/]()

 Use 'PostMan' or similar rest client for accessing the services


### To view your H2 in-memory datbase

To view and query the database you can browse to http://localhost:8080/h2-console. Default username is 'sa' with a blank password. 

Make sure that your JDBC Url is,

```
jdbc:h2:mem:testdb
```

For more, see [Spring docs](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-sql)


## About the Service

The application consist of couple of REST services. It uses an in-memory database (H2) to store the data. 
Here are some endpoints you can call:


### Create a todo resource

```
POST /api/v1/todos
Accept: application/json
Content-Type: application/json

{
"name" : "An Item",
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8090/api/v1/todos/1
```

### Retrieve a list of todo item.

```
http://localhost:8080/api/v1/todos

Response: HTTP 200
Content: List of todo items 
```

# Contributing

The [issue tracker](https://github.com/sam-rajan/kotlin-spring-boot-todolist/issues) is the preferred channel for bug reports, features requests and submitting pull requests.


