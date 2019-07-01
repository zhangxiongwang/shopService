package com.shop.store.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shop.store.domian.Store;

public interface StoreService {
	List<Store> getCloth();

	// getValueByProduct
	Page<Store> getProducts(Long id, int page, int pageSize, String desc, String asc, String clothId);

	String saveCloth(Store store);
}
