package com.company.demo;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.demo.entity.Address;
import com.company.demo.entity.Author;
import com.company.demo.entity.Book;
import com.company.demo.entity.Customer;
import com.company.demo.repository.AddressRepository;
import com.company.demo.repository.AuthorRepository;
import com.company.demo.repository.BookRepository;
import com.company.demo.repository.CustomerRepository;

@SpringBootApplication
public class MtomApplication {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
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

//	@PostConstruct
//	public void test2()
//	{
//		Customer dipi= new Customer();
//		dipi.setPhone("8946355202");
//		dipi.setPassword("null");
//		dipi.setAddresses(new ArrayList<>());
//		customerRepository.save(dipi);
//		
//		Address a1= new Address(null, "WB", "KOL", "KOL", "GT Road", "GT HOSPITAL", "700027", "37686", "7835", dipi);
//		dipi.getAddresses().add(a1);
//		customerRepository.save(dipi);
//	
//		
//	}
			
	
	

}