[![Build Status](https://travis-ci.org/jfreshik/book-and-author.svg?branch=master)](https://travis-ci.org/jfreshik/book-and-author)

# Spring Boot suppert for GraphQL
* https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot
* https://www.baeldung.com/spring-graphql

## dependencies
* pom.xml
```xml
<dependencies>
    ...
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
    ...
</dependencies>
```

## graphql resource

* define schema
```shell script
src/main/resources/author.graphqls
src/main/resources/book.graphqls

```

## Graphiql
* add dependency: _com.graphql-java:graphiql-spring-boot-starter:5.0.2_
* http://localhost:8080/graphiql

* query findAllAuthors
```graphql
{
    findAllAuthors {
        lastName
        firstName
    }
}
```

* query Book count
```graphql
{
	countBooks
}
```

* mutation newAuthor
```graphql
mutation {
    newAuthor(firstName: "Jongsik", lastName: "Kim") {
        lastName
        firstName
    }
}
```

* mutation delete Book
```graphql
mutation {
  deleteBook(id:1)
}
```

* mutation update Book Page Count
```graphql
mutation {
  updateBookPageCount(pageCount:50, id: 2) {
    title
    pageCount
  }
}
```

## Exception Handling
* unhandled error response
```graphql
mutation {
  deleteBook(id:999)
}
```
```json
{
  "data": {
    "deleteBook": null
  },
  "errors": [
    {
      "message": "No class com.example.graphql.model.Book entity with id 999 exists!",
      "path": [
        "deleteBook"
      ],
      "extensions": null,
      "locations": [
        {
          "line": 31,
          "column": 3,
          "sourceName": null
        }
      ],
      "errorType": "DataFetchingException"
    }
  ]
}
```

* refine error response (catch exception)
```graphql

mutation {
  updateBookPageCount(pageCount:50, id: 9999) {
    title
    pageCount
  }
}
```
```json

{
  "data": null,
  "errors": [
    {
      "message": "book not found",
      "path": [
        "updateBookPageCount"
      ],
      "extensions": {
        "invalidBookId": 9999
      },
      "locations": [
        {
          "line": 31,
          "column": 3,
          "sourceName": null
        }
      ],
      "errorType": "DataFetchingException"
    }
  ]
}
```