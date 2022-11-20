package com.company.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookShoppingAppApplication {

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookShoppingAppApplication.class, args);
		System.out.println("----- BACKEND SERVER RUNNING SUCCESSFULLY -----");
	}

	@PostConstruct
	public void test() {
//		User sayan = new User("sayan", "sayan123", "USER");
//		this.userRepository.save(sayan);
//		Customer csayan = new Customer("S", "M", "M", "1", "s@email", sayan);
//		this.customerRepository.save(csayan);
	}

}
