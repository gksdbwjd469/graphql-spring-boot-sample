package com.navercorp.graphql.exercise.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.navercorp.graphql.exercise.model.Author;
import com.navercorp.graphql.exercise.model.Book;
import com.navercorp.graphql.exercise.repository.AuthorRepository;
import com.navercorp.graphql.exercise.repository.BookRepository;


public class Query implements GraphQLQueryResolver {
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public long countBooks() {
		return bookRepository.count();
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}
