package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

//	Get All Book
	public List<Book> getAllBook() {
		return list;
	}

//	Get Specific Book
	public Book getBook(int id) {
		Book book = list.stream().filter(b -> b.getId() == id).findFirst().get();
		return book;

	}

//	Create Book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

//	Delete Specific
	public boolean deleteBook(int id) {
		Book book = list.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
		if (book == null) {
			return false;
		}
		return list.remove(book);
	}

//	Delete All Book
	public boolean deleteAllBook() {
		if (list.isEmpty()) {
			return false;
		} else {
			list.clear();
			return true;
		}
	}
	 
//	Update Book
	public void updateBook(Book book,int id) {
		list = list.stream().map(b->{
			
			if(b.getId() == id) {
				b.setName(book.getName());
				b.setPrice(book.getPrice());
			}
			return b;
		}).collect(Collectors.toList());

	}

}
