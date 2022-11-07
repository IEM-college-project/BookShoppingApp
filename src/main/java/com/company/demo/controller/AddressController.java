package com.company.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.entity.Address;
import com.company.demo.entity.Customer;
import com.company.demo.repository.AddressRepository;
import com.company.demo.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * 
	 * @api http://localhost:8888/api/address/create-address?customerId=5
	 * @param customerId
	 * @param address
	 * @return
	 */
	@PostMapping("/create-address")
	public String createAddress(@RequestParam Long customerId, @RequestBody Address address) {
		Customer customer = this.customerRepository.findById(customerId).orElse(null);

		if (customer == null)
			return "INVALID CUSTOMER ID " + customerId;

		address.setCustomer(customer);
		customer.getAddresses().add(address);
		this.customerRepository.save(customer);
		return "ADDRESS CREATED OF CUSTOMER WITH ID " + customerId;
	}

	/**
	 * 
	 * @api http://localhost:8888/api/address/update-address/7
	 * @param addressId
	 * @param address
	 * @return
	 */
	@PutMapping("/update-address/{id}")
	public String updateAddress(@PathVariable("id") Long addressId, @RequestBody Address address) {
		Address updatedAddress = this.addressRepository.findById(addressId).orElse(null);

		if (updatedAddress == null)
			return "INVALID ADDRESS ID " + addressId;

		updatedAddress.setName(address.getName());
		updatedAddress.setState(address.getState());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setLocality(address.getLocality());
		updatedAddress.setAddressLine(address.getAddressLine());
		updatedAddress.setPinCode(address.getPinCode());
		updatedAddress.setPhone(address.getPhone());
		updatedAddress.setAlternatePhone(address.getAlternatePhone());
		updatedAddress = this.addressRepository.save(updatedAddress);
		return "ADDRESS OF ID " + addressId + " UPDATED";
	}

}
