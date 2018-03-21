package com.navercorp.graphql.exercise.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.navercorp.graphql.exercise.model.Author;
import com.navercorp.graphql.exercise.model.Book;
import com.navercorp.graphql.exercise.repository.AuthorRepository;
import com.navercorp.graphql.exercise.repository.BookRepository;


public class Mutation implements GraphQLMutationResolver {
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	public Author newAuthor(String name) {
		Author author = Author.builder()
			.name(name)
			.build();

		authorRepository.save(author);
		return author;
	}

	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = Book.builder()
			.author(Author.builder()
				.id(authorId)
				.build())
			.title(title)
			.isbn(isbn)
			.pageCount(pageCount != null ? pageCount : 0)
			.build();

		bookRepository.save(book);
		return book;
	}

	public boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Book updateBookPageCount(Integer pageCount, Long id) {
		Book book = bookRepository.findById(id).get();
		book.setPageCount(pageCount);

		bookRepository.save(book);
		return book;
	}
}