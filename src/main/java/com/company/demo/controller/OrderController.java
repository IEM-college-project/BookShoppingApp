package com.company.demo.controller;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> bugfix
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.company.demo.entity.Address;
import com.company.demo.entity.Book;
import com.company.demo.entity.Order;
import com.company.demo.entity.OrderDetails;
import com.company.demo.repository.AddressRepository;
import com.company.demo.repository.BookRepository;
import com.company.demo.repository.OrderRepository;
=======
import com.company.demo.entity.Order;
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;
import com.company.demo.service.OrderService;
>>>>>>> bugfix

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/order")
public class OrderController {

<<<<<<< HEAD
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
=======
	@Autowired
	private OrderService orderService;

	@PostMapping("/place-order")
	public ResponseEntity<?> createOrder(@RequestParam Long addressId, @RequestBody List<List<Long>> orders)
			throws EntityNotFoundException {
		Order createdOrder = this.orderService.createOrder(addressId, orders);
		return ResponseEntity.status(201).body(createdOrder);
	}

	@GetMapping("/fetch-all")
	public ResponseEntity<?> readAllOrder() throws NoEntitiesException {
		List<Order> orders = this.orderService.readAllOrder();
		return ResponseEntity.status(200).body(orders);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> readOrderById(@PathVariable("id") Long orderId) throws EntityNotFoundException {
		Order order = this.orderService.readOrderById(orderId);
		return ResponseEntity.status(200).body(order);
>>>>>>> bugfix
	}

}
