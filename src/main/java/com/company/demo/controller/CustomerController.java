package com.company.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.entity.Customer;
import com.company.demo.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
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
	}

}
