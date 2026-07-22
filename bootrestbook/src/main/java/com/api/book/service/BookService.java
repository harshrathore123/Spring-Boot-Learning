package com.api.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

@Component
public class BookService {

	public static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(1, "Java", 322));
		list.add(new Book(2, "C", 321));
		list.add(new Book(3, "Python", 789));
	}

	public List<Book> getAllBook() {
		return list;
	}

	public Book getBook(int id) {
	
		Book book = list.stream().filter(b -> b.getId() == id).findFirst().get();
		return book;

	}
}
