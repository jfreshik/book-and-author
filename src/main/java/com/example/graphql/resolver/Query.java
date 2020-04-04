package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import com.example.graphql.type.CustomPaging;
import org.springframework.data.domain.Page;

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

    public Iterable<Book> findAllBooksPage(CustomPaging paging) {
        return bookRepository.findAllPage(paging.toPageRequest()).getContent();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAllWithFetchJoin();
    }

    public Iterable<Author> findAllAuthorsPage(CustomPaging paging) {
        Page<Author> allPage = authorRepository.findAllPage(paging.toPageRequest());
        return allPage.getContent();
    }

    public int countBooks() {
        return (int) bookRepository.count();
    }

    public int countAuthors() {
        return (int) authorRepository.count();
    }
}
