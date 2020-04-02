package com.example.graphql.repository;

import com.example.graphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a left join fetch a.bookList")
    List<Author> findAllWithFetchJoin();
}
