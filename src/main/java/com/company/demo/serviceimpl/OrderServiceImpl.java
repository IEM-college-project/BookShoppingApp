package com.company.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.demo.entity.Order;
import com.company.demo.exception.EntityNotFoundException;
import com.company.demo.exception.NoEntitiesException;
import com.company.demo.repository.OrderRepository;
import com.company.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order createOrder(Long addressId, List<List<Long>> orders) {
		return null;
	}

	@Override
	public List<Order> readAllOrder() throws NoEntitiesException {
		List<Order> orders = this.orderRepository.findAll();

		if (orders.size() > 0)
			return orders;

		throw new NoEntitiesException("No order exists till now");
	}

	@Override
	public Order readOrderById(Long orderId) throws EntityNotFoundException {
		Order order = this.orderRepository.findById(orderId)
				.orElseThrow(() -> new EntityNotFoundException("No order found with id: " + orderId));
		return order;
	}

}
