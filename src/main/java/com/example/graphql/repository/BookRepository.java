package com.example.graphql.repository;

import com.example.graphql.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b left join fetch b.author")
    List<Book> findAllWithFetchJoin();

    /**
     * pageable 을 처리하기 위해 countQuery 를 지정
     * countQuery 에는 fetch 키워드 삭제!!
     */
    @Query(value = "select b from Book b left join fetch b.author",
            countQuery = "select count(b) from Book b left join b.author")
    Page<Book> findAllPage(Pageable pageable);
}
