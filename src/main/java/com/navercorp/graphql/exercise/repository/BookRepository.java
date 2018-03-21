package com.navercorp.graphql.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.navercorp.graphql.exercise.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}