package com.shop.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.user.domian.UserView;

public interface UserViewRepository extends JpaRepository<UserView, Integer> {
	UserView findByUsername(String username);
}
