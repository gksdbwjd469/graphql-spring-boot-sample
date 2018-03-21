package com.navercorp.graphql.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.navercorp.graphql.exercise.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}