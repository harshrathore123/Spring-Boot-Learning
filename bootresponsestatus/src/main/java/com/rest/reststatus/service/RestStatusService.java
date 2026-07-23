package com.rest.reststatus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.reststatus.entities.RestStatusBook;

@Component
public class RestStatusService {
	public static List<RestStatusBook> list = new ArrayList<>();

	static {
		list.add(new RestStatusBook(1, "Java", 322));
		list.add(new RestStatusBook(2, "C", 321));
		list.add(new RestStatusBook(3, "Python", 789));
	}

//	Get All Book
	public List<RestStatusBook> getAllBook() {
		return list;
	}

//	Get Specific Book
	public RestStatusBook getBook(int id) {
		RestStatusBook book = null;
		try {
			book = list.stream().filter(b -> b.getId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

//	Create Book
	public RestStatusBook addBook(RestStatusBook book) {
		list.add(book);
		return book;
	}

//	Delete Specific
	public boolean deleteBook(int id) {
		RestStatusBook book = list.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
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
	public void updateBook(RestStatusBook book, int id) {
		list = list.stream().map(b -> {

			if (b.getId() == id) {
				b.setName(book.getName());
				b.setPrice(book.getPrice());
			}
			return b;
		}).collect(Collectors.toList());

	}

}
