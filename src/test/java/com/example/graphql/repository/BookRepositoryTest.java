package com.example.graphql.repository;

import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAll_cause_N_plus_1_problem(){

        System.out.println("-------- <><><>><>><><><><> ---------------");

        List<Book> books = bookRepository.findAll();
        assertFalse(CollectionUtils.isEmpty(books));

        Author author1 = books.get(0).getAuthor();
        assertNotNull(author1);
    }

    @Test
    public void findAllByFetchJoin_prevent_N_plus_1() {

        // @Query("select b from Book b left join fetch b.author")
        List<Book> books = bookRepository.findAllWithFetchJoin();
        assertFalse(CollectionUtils.isEmpty(books));

        Author author1 = books.get(0).getAuthor();
        assertNotNull(author1);
    }
}