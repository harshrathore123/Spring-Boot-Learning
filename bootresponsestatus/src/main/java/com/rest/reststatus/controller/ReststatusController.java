package com.rest.reststatus.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.reststatus.entities.RestStatusBook;
import com.rest.reststatus.service.RestStatusService;

@RestController
public class ReststatusController {

	private final RestStatusService bookservice;

	ReststatusController(RestStatusService bookservice) {
		this.bookservice = bookservice;
	}

	@GetMapping("/book")
	public ResponseEntity<List<RestStatusBook>> getBooks() {
		List<RestStatusBook> list = bookservice.getAllBook();

		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<RestStatusBook> getBook(@PathVariable("id") int id) {
		RestStatusBook restbook = bookservice.getBook(id);
		if (restbook == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(restbook));
	}

	@PostMapping("/book")
	public ResponseEntity<RestStatusBook> addBook(@RequestBody RestStatusBook book) {
		RestStatusBook b = null;
		try {
			this.bookservice.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int identity) {
		try {
			this.bookservice.deleteBook(identity);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@DeleteMapping("/book")
	public ResponseEntity<Void> deleteBooks() {
		try {
			this.bookservice.deleteAllBook();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<RestStatusBook> updationBook(@RequestBody RestStatusBook book, @PathVariable("id") int id) {
		try {
			this.bookservice.updateBook(book, id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
