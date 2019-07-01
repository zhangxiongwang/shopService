package com.shop.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.shop.order.domain.Order;

public interface OrderService {
	public Page<Order> getOrders(String username, int pageNo, int PageSize);

	public Map<String, Object> getOrderById(Integer id);

	public String saveOrders(List<Order> orders);
}
