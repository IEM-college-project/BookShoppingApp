package com.company.demo.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> bugfix
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.entity.Customer;
<<<<<<< HEAD
import com.company.demo.repository.CustomerRepository;
=======
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;
import com.company.demo.service.CustomerService;
>>>>>>> bugfix

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
<<<<<<< HEAD
	private CustomerRepository customerRepository;

	/**
	 * 
	 * @api http://localhost:8888/api/customer/create-customer
	 * @param customer
	 * @return
	 */
	@PostMapping("/create-customer")
	public String createCustomer(@RequestBody Customer customer) {
		customer = this.customerRepository.save(customer);
		Long customerId = customer.getCustomerId();
		return "CUSTOMER OF ID " + customerId + " CREATED";
	}

	/**
	 * 
	 * @api http://localhost:8888/api/customer/update-customer/5
	 * @param customerId
	 * @param customer
	 * @return
	 */
	@PutMapping("/update-customer/{id}")
	public String updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer) {
		Customer updatedCustomer = this.customerRepository.findById(customerId).orElse(null);

		if (updatedCustomer == null)
			return "INVALID CUSTOMER ID " + customerId;

		updatedCustomer.setFirstName(customer.getFirstName());
		updatedCustomer.setLastName(customer.getLastName());
		updatedCustomer.setGender(customer.getGender());
		updatedCustomer.setPhone(customer.getPhone());
		updatedCustomer.setEmail(customer.getEmail());
		updatedCustomer = this.customerRepository.save(updatedCustomer);
		return "CUSTOMER OF ID " + customerId + " UPDATED";
=======
	private CustomerService customerService;

	@GetMapping("/fetch-all")
	public ResponseEntity<?> readAllCustomer() throws NoEntitiesException {
		List<Customer> customers = this.customerService.readAllCustomer();
		return ResponseEntity.status(200).body(customers);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> readCustomerById(@PathVariable("id") Long customerId) throws EntityNotFoundException {
		Customer customer = this.customerService.readCustomerById(customerId);
		return ResponseEntity.status(200).body(customer);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("id") Long customerId, @RequestBody Customer customer)
			throws EntityNotFoundException {
		Customer updatedCustomer = this.customerService.updateCustomerById(customerId, customer);
		return ResponseEntity.status(201).body(updatedCustomer);
>>>>>>> bugfix
	}

}
