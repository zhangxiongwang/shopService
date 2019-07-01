package com.shop.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.user.domian.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	User findByUsernameAndPassword(String username,String password);
}
