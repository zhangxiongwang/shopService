package com.shop.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.shop.jpush.Jpush;
import com.shop.user.domian.User;
import com.shop.user.domian.UserView;
import com.shop.user.repository.UserRepository;
import com.shop.user.repository.UserViewRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserViewRepository userViewRepository;

	@Override
	public Map<String, Object> login(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String psd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			result.put("data", "用户名或密码不能为空");
			return result;
		}
		User hasUser = userRepository.findByUsername(user.getUsername());
		if (hasUser == null) {
			result.put("data", "用户名不存在");
			return result;
		}
		User person = userRepository.findByUsernameAndPassword(user.getUsername(), psd);
		if (person == null) {
			result.put("data", "密码错误");
			return result;
		}
		result.put("data", "登录成功");
		String[] strings = { "Welcome to my graduation project!", user.getUsername() };
		// 登录成功推送消息
		Jpush.main(strings);
		return result;

	}

	public Map<String, Object> getUserByUsername(String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserView user = userViewRepository.findByUsername(username);
		result.put("data", user);

		return result;

	}

	@Override
	public Map<String, Object> regist(User user) {
		User hasUser = userRepository.findByUsername(user.getUsername());
		Map<String, Object> result = new HashMap<String, Object>();
		if (hasUser == null) {
			String psd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
			user.setPassword(psd);
			userRepository.save(user);
			result.put("data", "注册成功");
			return result;

		}
		result.put("data", "当前用户已存在");
		return result;

	}
}
