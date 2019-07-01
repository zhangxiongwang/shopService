package com.shop.order.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	Page<Order> findByUsername(String username,Pageable page);
	
	void save(List<Order> orders);
		

}
