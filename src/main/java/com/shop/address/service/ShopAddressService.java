package com.shop.address.service;

import java.util.Map;

import com.shop.address.domain.ShopAddress;

public interface ShopAddressService {

	Map<String, Object> getAllAddress(String username);

	Map<String, Object> getAddress(Boolean defult, String username);

	Map<String, Object> updateAddress(ShopAddress address);

	Map<String, Object> addAddress(ShopAddress address);

	Map<String, Object> updateById(ShopAddress address);

	Map<String, Object> delAddress(Integer id);

}
