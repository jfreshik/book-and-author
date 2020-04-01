# Spring Boot suppert for GraphQL
* https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot
* https://www.baeldung.com/spring-graphql

## dependencies
* graphQL
```xml
		<dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
            <version>5.0.2</version>
        </dependency>

        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java-tools</artifactId>
            <version>5.2.4</version>
        </dependency>

        <!-- GraphiQL -->
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphiql-spring-boot-starter</artifactId>
            <version>5.0.2</version>
        </dependency>
```

## application.properties

* enable H2 console
```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## graphql resource

* define schema
```shell script
src/main/resources/*.graphqls
```

## Graphiql
* add dependency _com.graphql-java:graphiql-spring-boot-starter:5.0.2_
* http://localhost:8080/graphiql