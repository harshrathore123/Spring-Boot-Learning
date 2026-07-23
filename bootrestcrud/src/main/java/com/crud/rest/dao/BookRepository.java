package com.crud.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.rest.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
