package com.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.demo.entity.Address;
import com.company.demo.entity.Author;
import com.company.demo.entity.Book;
import com.company.demo.entity.Customer;
import com.company.demo.repository.BookRepository;
import com.company.demo.repository.CustomerRepository;

@SpringBootApplication
public class MtomApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(MtomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer sayan = new Customer("Sayan", "Das", "M", "7596859012", "sayan@gmail.com");
		Customer arpan = new Customer("Arpan", "Ghosh", "M", "7596859011", "arpan@gmail.com");

		Address address1 = new Address("WB", "Kolkata", "B.T. Road", "700108");
		Address address2 = new Address("WB", "Kolkata", "G.T. Road", "700109");
		Address address3 = new Address("WB", "Kolkata", "C.T. Road", "700110");

		arpan.getAddresses().add(address1);
		arpan.getAddresses().add(address2);
		sayan.getAddresses().add(address2);
		sayan.getAddresses().add(address3);

		address1.getCustomers().add(arpan);
		address2.getCustomers().add(arpan);
		address2.getCustomers().add(sayan);
		address3.getCustomers().add(sayan);

		this.customerRepository.save(arpan);
		this.customerRepository.save(sayan);

		// =========================================================

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
	}

}
