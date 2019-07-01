package com.shop.user.service;

import java.util.Map;

import com.shop.user.domian.User;

public interface UserService {
	Map<String, Object> login(User user);

	Map<String, Object> getUserByUsername(String username);

	Map<String, Object> regist(User user);
}
