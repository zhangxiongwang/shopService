package com.shop.order.service;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.shop.address.domain.ShopAddress;
import com.shop.address.repository.ShopAddressRepository;
import com.shop.order.domain.Order;
import com.shop.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ShopAddressRepository shopAddressRepository;

	@Override
	public Page<Order> getOrders(String username, int pageNo, int pageSize) {

		Page<Order> orders = orderRepository.findByUsername(username, new PageRequest(pageNo, pageSize));
		return orders;
	}

	@Override
	public Map<String, Object> getOrderById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Optional<Order> order = orderRepository.findById(id);
		Order o = order.get();
		Optional<ShopAddress> address = shopAddressRepository.findById(o.getAddressid());
		ShopAddress address2 = address.get();
		o.setAddress(address2);
		map.put("data", order);
		return map;
	}

	public String saveOrders(List<Order> orders) {
		for (Order o : orders) {
			o.setStatus("已完成");
		}
		orderRepository.saveAll(orders);
		String s = "保存成功";

		return s;
	}
}
