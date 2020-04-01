package com.example.graphql;

import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.model.Book;
import com.example.graphql.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookAndAuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAndAuthorApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author author1 = new Author("Herbert", "Schildt");
			authorRepository.save(author1);
			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author1));
			bookRepository.save(new Book("Java: A Beginner's Guide, seventh Edition", "0071809253", 810, author1));
			bookRepository.save(new Book("Java: A Beginner's Guide, eighth Edition", "0071809254", 954, author1));

			Author author2 = new Author("Tester1", "tttt");
			authorRepository.save(author2);
			bookRepository.save(new Book("Lololo 1st", "123451231", 10, author2));
			bookRepository.save(new Book("Lololo 2nd", "123323333", 11, author2));
		};
	}
}
