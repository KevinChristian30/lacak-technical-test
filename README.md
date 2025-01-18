# Lacak Technical Test

## System Requirements
- Java 17
- Maven 3.6.3 or later
- Postgre SQL 16

## Run App
- Create/Modify a local configuration file
```dtd
spring:
    jpa:
        show-sql: true
        hibernate:
        ddl-auto: validate
    datasource:
        url: <database url>
        username: <database username>
        password: <database password>
    flyway:
        url: <database url>
        user: <database username>
        password: <database password>
```

- Build the app by executing
```shell
mvn clean package
```

- Run the JAR
```shell
java -jar target/app-0.0.1-SNAPSHOT.jar
```

- Run unit tests
```shell
mvn test
```

- Deployed App
```shell
https://lacak-technical-test-production.up.railway.app/api/v1/suggestions?q=New York City&latitude=40.71427&longitude=-74.00597&pageNumber=1&perPage=10
```