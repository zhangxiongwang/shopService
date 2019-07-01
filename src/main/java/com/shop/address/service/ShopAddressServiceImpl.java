package com.shop.address.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.address.domain.ShopAddress;
import com.shop.address.repository.ShopAddressRepository;

@Service
public class ShopAddressServiceImpl implements ShopAddressService {
	@Autowired
	ShopAddressRepository addressRepository;

	@Override
	public Map<String, Object> getAllAddress(String username) {
		List<ShopAddress> address = addressRepository.findByUsername(username);
		Map<String, Object> map = new HashMap<>();
		map.put("data", address);
		return map;
	}

	@Override
	public Map<String, Object> getAddress(Boolean defult, String username) {
		ShopAddress address = addressRepository.findByDefultAndUsername(defult, username);
		Map<String, Object> map = new HashMap<>();
		map.put("data", address);
		return map;
	}

	@Override
	public Map<String, Object> updateAddress(ShopAddress address) {
		ShopAddress addre = addressRepository.findByDefultAndUsername(true, address.getUsername());
		Map<String, Object> map = new HashMap<>();
		if (addre.getId() == address.getId()) {
			map.put("data", "ok");
			return map;
		} else {
			addressRepository.updateDefult(false, addre.getId(), addre.getUsername());
			addressRepository.updateDefult(true, address.getId(), address.getUsername());
			map.put("data", "ok");
			return map;
		}

	}

	@Override
	public Map<String, Object> updateById(ShopAddress address) {
		addressRepository.save(address);
		Map<String, Object> map = new HashMap<>();
		map.put("data", "ok");
		return map;
	}

	@Override
	public Map<String, Object> delAddress(Integer id) {
		addressRepository.deleteById(id);
		Map<String, Object> map = new HashMap<>();
		map.put("data", "ok");
		return map;
	}

	@Override
	public Map<String, Object> addAddress(ShopAddress address) {
		List<ShopAddress> addresses = addressRepository.findByUsername(address.getUsername());
		if (addresses.size() == 0) {
			address.setDefult(true);
		}
		addressRepository.save(address);
		Map<String, Object> map = new HashMap<>();
		map.put("data", "ok");
		return map;
	}
}
