package com.navercorp.graphql.exercise.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;

import com.navercorp.graphql.exercise.model.Author;
import com.navercorp.graphql.exercise.model.Book;
import com.navercorp.graphql.exercise.repository.AuthorRepository;


public class BookResolver implements GraphQLResolver<Book> {
	private AuthorRepository authorRepository;

	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Book book) {
		return authorRepository.findById(book.getAuthor().getId())
			.get();
	}
}