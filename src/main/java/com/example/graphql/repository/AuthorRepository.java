package com.example.graphql.repository;

import com.example.graphql.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a left join fetch a.bookList")
    List<Author> findAllWithFetchJoin();

    /**
     * pageable 을 처리하기 위해 countQuery 를 지정
     * countQuery 에는 fetch 키워드 삭제!!
     */
    @Query(value = "select a from Author a left join fetch a.bookList",
            countQuery = "select a from Author a left join a.bookList")
    Page<Author> findAllPage(Pageable pageable);
}
