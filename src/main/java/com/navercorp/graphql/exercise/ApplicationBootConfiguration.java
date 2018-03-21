package com.navercorp.graphql.exercise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.navercorp.graphql.exercise.model.Author;
import com.navercorp.graphql.exercise.model.Book;
import com.navercorp.graphql.exercise.repository.AuthorRepository;
import com.navercorp.graphql.exercise.repository.BookRepository;
import com.navercorp.graphql.exercise.resolver.BookResolver;
import com.navercorp.graphql.exercise.resolver.Mutation;
import com.navercorp.graphql.exercise.resolver.Query;

@SpringBootApplication
public class ApplicationBootConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootConfiguration.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author = Author.builder()
				.name("yu.jeong")
				.build();

			authorRepository.save(author);

			Book book = Book.builder()
				.title("graphql and spring boot")
				.isbn("0000587625465")
				.pageCount(777)
				.author(author)
				.build();

			bookRepository.save(book);
		};
	}
}