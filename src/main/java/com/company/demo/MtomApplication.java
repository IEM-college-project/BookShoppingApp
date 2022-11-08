package com.company.demo;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.demo.entity.Author;
import com.company.demo.entity.Book;
import com.company.demo.repository.AuthorRepository;
import com.company.demo.repository.BookRepository;

@SpringBootApplication
public class MtomApplication {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(MtomApplication.class, args);

	}

	@PostConstruct
	public void test() {
		Book java = new Book(null, "Java", 800L, 750.00, 100L, new ArrayList<>());
		Book python = new Book(null, "Python", 700L, 850.00, 200L, new ArrayList<>());

		Author gosling = new Author(null, "Gosling", "g@mail", new ArrayList<>());
		Author rossum = new Author(null, "Rossum", "r@mail", new ArrayList<>());

		java.getAuthors().add(gosling);
		python.getAuthors().add(gosling);
		python.getAuthors().add(rossum);

		gosling.getBooks().add(java);
		gosling.getBooks().add(python);
		rossum.getBooks().add(python);

		bookRepository.save(java);
		bookRepository.save(python);
		authorRepository.save(gosling);
		authorRepository.save(rossum);

	}

}