package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class BookResolver  implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElse(null);
    }
}
