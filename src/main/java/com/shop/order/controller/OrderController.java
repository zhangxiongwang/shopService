package com.shop.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.order.domain.Order;
import com.shop.order.service.OrderService;
import com.shop.store.domian.Store;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	public ResponseEntity<Page<Order>> getOrder(@RequestParam(required = false) String username,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize) {
		Page<Order> order = orderService.getOrders(username, pageNo, pageSize);
		return ResponseEntity.ok(order);
	}
	@RequestMapping(value = "/getOrderById", method = RequestMethod.GET)
	public Map<String, Object> getOrderById(@RequestParam(required = false) Integer id) {
		return orderService.getOrderById(id);
	}
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public Map<String, Object> saveOrder(@RequestBody List<Order> orders) {
		Map<String, Object> order = new HashMap<>();
		order.put("data", orderService.saveOrders(orders));
		return order;
	}

}
