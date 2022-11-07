package com.company.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.demo.entity.Author;
import com.company.demo.entity.Book;
import com.company.demo.repository.BookRepository;

@SpringBootApplication
public class MtomApplication {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(MtomApplication.class, args);
	}

	@PostConstruct
	public void test() {
		Book java = new Book("Learn Java", 990L, 1250.00, 120L);
		Book python = new Book("Learn Python", 1100L, 950.00, 90L);

		Author aniket = new Author("Aniket", "aniket@gmail.com");
		Author amitava = new Author("Amitava", "amitava@gmail.com");

		java.getAuthors().add(aniket);
		java.getAuthors().add(amitava);
		python.getAuthors().add(amitava);

		aniket.getBooks().add(java);
		amitava.getBooks().add(java);
		amitava.getBooks().add(python);

		this.bookRepository.save(java);
		this.bookRepository.save(python);
		System.out.println("All books and authors are saved");
	}

}
