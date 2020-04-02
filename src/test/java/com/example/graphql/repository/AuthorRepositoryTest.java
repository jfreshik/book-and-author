package com.example.graphql.repository;

import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void fetchJoin() {

        List<Author> authors = authorRepository.findAllWithFetchJoin();
        assertFalse(CollectionUtils.isEmpty(authors));

        List<Book> authorsBookList = authors.get(0).getBookList();
        assertFalse(CollectionUtils.isEmpty(authorsBookList));
    }
}