package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.data.domain.PageRequest;

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

    public Iterable<Book> findAllBooksPage(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        return bookRepository.findAllPage(pr).getContent();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAllWithFetchJoin();
    }

    public Iterable<Author> findAllAuthorsPage(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);
        return authorRepository.findAllPage(pr).getContent();
    }

    public int countBooks() {
        return (int) bookRepository.count();
    }

    public int countAuthors() {
        return (int) authorRepository.count();
    }
}
