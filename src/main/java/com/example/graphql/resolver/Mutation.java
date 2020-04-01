package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.exception.BookNotFoundException;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author newAuthor(String firstName, String lastName) {
        return authorRepository.save(new Author(firstName, lastName));
    }

    @Transactional
    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book(title, isbn, pageCount, new Author(authorId));
        bookRepository.save(book);
        return book;
    }

    @Transactional
    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Book updateBookPageCount(Integer pageCount, Long id) {
        Optional<Book> book = bookRepository.findById(id);
        Book foundBook = book.orElseThrow(() -> new BookNotFoundException("book not found", id));
        foundBook.setPageCount(pageCount);
        return foundBook;
    }
}
