package com.crud.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crud.rest.dao.BookRepository;
import com.crud.rest.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

//	Get All Book
	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}

//	Get Specific Book
	public Book getBook(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

//	Create Book
	public Book addBook(Book book) {
		Book result = bookRepository.save(book);
		return result;
	}

//	Delete Specific
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

//	Delete All Book
	public void deleteAllBook() {
		bookRepository.deleteAll();
	}
	 
//	Update Book
	public void updateBook(Book book,int id) {
		book.setId(id);
		bookRepository.save(book);
	}

}
