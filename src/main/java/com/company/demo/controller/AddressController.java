package com.company.demo.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> bugfix
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.entity.Address;
<<<<<<< HEAD
import com.company.demo.entity.Customer;
import com.company.demo.repository.AddressRepository;
import com.company.demo.repository.CustomerRepository;
=======
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;
import com.company.demo.service.AddressService;
>>>>>>> bugfix

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
<<<<<<< HEAD
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
=======
	private AddressService addressService;

	@PostMapping("/add")
	public ResponseEntity<?> createAddress(@RequestParam Long customerId, @RequestBody Address address)
			throws EntityNotFoundException {
		Address createdAddress = this.addressService.createAddress(customerId, address);
		return ResponseEntity.status(201).body(createdAddress);
	}

	@GetMapping("/fetch-all")
	public ResponseEntity<?> readAllAddress() throws NoEntitiesException {
		List<Address> addresses = this.addressService.readAllAddress();
		return ResponseEntity.status(200).body(addresses);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> readAddressById(@PathVariable("id") Long addressId) throws EntityNotFoundException {
		Address address = this.addressService.readAddressById(addressId);
		return ResponseEntity.status(200).body(address);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateAddressById(@PathVariable("id") Long addressId, @RequestBody Address address)
			throws EntityNotFoundException {
		Address updatedAddress = this.addressService.updateAddressById(addressId, address);
		return ResponseEntity.status(201).body(updatedAddress);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAddressById(@PathVariable("id") Long addressId) throws EntityNotFoundException {
		String message = this.addressService.deleteAddressById(addressId);
		return ResponseEntity.status(200).body(message);
>>>>>>> bugfix
	}

}
