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

	private static int quantityCount = 0;

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
	public String createOrder(@RequestParam Long addressId, @RequestBody List<List<Long>> orders) {
		Address address = this.addressRepository.findById(addressId).orElse(null);

		if (address == null)
			return "INVALID ADDRESS ID " + addressId;

		Order order = new Order(false, address);
		this.orderRepository.save(order);

		List<Book> books = new ArrayList<>();
		orders.get(0).forEach(bookId -> {
			books.add(this.bookRepository.findById(bookId).orElse(null));
		});

		List<Long> quantities = new ArrayList<>();
		orders.get(1).forEach(quantity -> {
			quantities.add(quantity);
		});

		quantityCount = 0;
		books.forEach(book -> {
			book.getOrderDetails().add(new OrderDetails(quantities.get(quantityCount++), book, order));
		});

		this.bookRepository.saveAll(books);
		return "ORDER CREATED OF ADDRESS WITH ID " + addressId;
	}

}
