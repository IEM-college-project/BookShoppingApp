package com.company.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.demo.entity.Author;
import com.company.demo.entity.Book;
import com.company.demo.repository.BookRepository;

@SpringBootApplication
public class BookShoppingAppApplication {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookShoppingAppApplication.class, args);
		System.out.println("----- BACKEND SERVER RUNNING SUCCESSFULLY -----");
	}

	@PostConstruct
	public void test() {
		Book java = new Book("Learn Java", 990L, 1250.00, 120L);
		Author gosling = new Author("James Gosling", "gosling@java.com");
		Author rossum = new Author("Guido Van Rossum", "rossum@python.com");

		rossum.setBooks(Arrays.asList(java));
		gosling.setBooks(Arrays.asList(java));
		java.setAuthors(Arrays.asList(gosling, rossum));

		this.bookRepository.save(java);
		System.out.println("----- ALL BOOKS AND AUTHORS ARE SAVED -----");
	}

}
