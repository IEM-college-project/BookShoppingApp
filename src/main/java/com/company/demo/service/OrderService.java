package com.company.demo.service;

import java.util.List;

import com.company.demo.entity.Order;

public interface OrderService {

	public Order createOrder(Long addressId, List<List<Long>> orders);

}
