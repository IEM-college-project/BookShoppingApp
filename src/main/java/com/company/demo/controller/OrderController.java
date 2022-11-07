package com.company.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.demo.entity.Address;
import com.company.demo.entity.Book;
import com.company.demo.entity.Order;
import com.company.demo.entity.OrderDetails;
import com.company.demo.repository.AddressRepository;
import com.company.demo.repository.BookRepository;
import com.company.demo.repository.OrderRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AddressRepository addressRepository;

	/**
	 * 
	 * @api http://localhost:8888/api/order/create-order?addressId=8
	 * @param addressId
	 * @param order
	 * @return
	 */
	@PostMapping("/create-order")
	public String createOrder(@RequestParam Long addressId, @RequestBody List<Long> bookIds) {
		Order order = new Order(false);
		List<Book> books = new ArrayList<>();
		Address address = this.addressRepository.findById(addressId).orElse(null);

		if (address == null)
			return "INVALID ADDRESS ID " + addressId;

		order.setAddress(address);
		this.orderRepository.save(order);
		this.addressRepository.save(address);

		bookIds.forEach(bookId -> {
			books.add(this.bookRepository.findById(bookId).orElse(null));
		});

		books.forEach(book -> {
			book.getOrderDetails().add(new OrderDetails(null, 3L, book, order));
		});

		this.bookRepository.saveAll(books);
		return "ORDER CREATED OF ADDRESS WITH ID " + addressId;
	}

}
