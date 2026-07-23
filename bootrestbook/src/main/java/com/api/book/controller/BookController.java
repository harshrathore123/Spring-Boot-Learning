package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;

	@GetMapping("/book")
	public List<Book> getBooks() {
		return this.bookservice.getAllBook();
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookservice.getBook(id);
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookservice.addBook(book);
		System.out.println(b);
		return b;
	}

	@DeleteMapping("/book/{id}")
	public boolean deleteBook(@PathVariable("id") int identity) {
		return this.bookservice.deleteBook(identity);
	}

	@DeleteMapping("/book")
	public boolean deleteBooks() {
		return this.bookservice.deleteAllBook();
	}

	@PutMapping("/book/{id}")
	public Book updationBook(@RequestBody Book book,@PathVariable("id") int id) {
		this.bookservice.updateBook(book,id);
		return book;
	}
}
