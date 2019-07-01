package com.shop.address.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shop.address.domain.ShopAddress;
import com.shop.address.service.ShopAddressService;

@RestController
public class ShopAddressController {
	@Autowired
	ShopAddressService addressService;
	@Autowired
    private RestTemplate restTemplate;
	// 获取全部地址
	@RequestMapping(value = "/getAllAddress", method = RequestMethod.GET)
	public Map<String, Object> getAllAddress(@RequestParam String username) {
		return addressService.getAllAddress(username);
	}

	// 获取选中地址
	@RequestMapping(value = "/getAddress", method = RequestMethod.GET)
	public Map<String, Object> getAddress(@RequestParam Boolean defult, @RequestParam String username) {
		return addressService.getAddress(defult, username);
	}

	// 更新选中地址
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public Map<String, Object> updateAddress(@RequestBody ShopAddress address) {
		return addressService.updateAddress(address);
	}

	// 新增选中地址
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public Map<String, Object> addAddress(@RequestBody ShopAddress address) {
		return addressService.addAddress(address);
	}
	// 更新地址信息
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	public Map<String, Object> updateById(@RequestBody ShopAddress address) {
		return addressService.updateById(address);
	}
	// 删除地址
	@RequestMapping(value = "/delAddress", method = RequestMethod.GET)
	public Map<String, Object> delAddress(@RequestParam Integer id) {
		return addressService.delAddress(id);
	}
}
