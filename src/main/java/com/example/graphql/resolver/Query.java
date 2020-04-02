package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;

public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAllWithFetchJoin();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAllWithFetchJoin();
    }

    public int countBooks() {
        return (int) bookRepository.count();
    }

    public int countAuthors() {
        return (int) authorRepository.count();
    }
}
