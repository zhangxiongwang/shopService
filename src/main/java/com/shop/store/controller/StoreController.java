package com.shop.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.store.domian.Store;
import com.shop.store.service.StoreService;

@RestController
public class StoreController {
	@Autowired
	StoreService storeService;

	@RequestMapping(value = "/getcloth", method = RequestMethod.GET)
	public ResponseEntity<List<Store>> getcloth() {
		List<Store> clothes = storeService.getCloth();
		return ResponseEntity.ok(clothes);
	}

	@RequestMapping(value = "/getproducts", method = RequestMethod.GET)
	public ResponseEntity<Page<Store>> getProducts(@RequestParam(required = true) Long favoritesId,
			@RequestParam(defaultValue = "0", required = false) Integer pageNo,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(required = false) String desc, @RequestParam(required = false) String asc,
			@RequestParam(required = false) String id) {
		Page<Store> clothes = storeService.getProducts(favoritesId, pageNo, pageSize,desc,asc,id);
		return ResponseEntity.ok(clothes);
	}

	@RequestMapping(value = "savecloth", method = RequestMethod.POST)
	public String saveCloth(@RequestBody(required = false) Store store) {
		storeService.saveCloth(store);

		return "ok";
	}
}
