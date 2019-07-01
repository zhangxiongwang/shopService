package com.shop.store.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.shop.image.domain.Image;
import com.shop.image.repository.ImageRepository;
import com.shop.store.domian.Store;
import com.shop.store.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	ImageRepository imageRepository;

	@Override
	public List<Store> getCloth() {
		List<Store> stores = storeRepository.findAll();
		return stores;

	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<Store> getProducts(Long id, int page, int pageSize, String desc, String asc, String clothId) {
		Page<Store> stores = null;
		if (desc == null && asc == null && clothId == null) {
			stores = storeRepository.findByFavoritesid(id, new PageRequest(page, pageSize));
		} else {
			if (desc.equals("1")) {
				stores = storeRepository.findByFavoritesidOrderByZkfinalpriceDesc(id, new PageRequest(page, pageSize));
			} else if (asc.equals("1")) {
				stores = storeRepository.findByFavoritesidOrderByZkfinalpriceAsc(id, new PageRequest(page, pageSize));

			} else if (clothId.equals("1")) {
				stores = storeRepository.findByFavoritesidOrderByIdDesc(id, new PageRequest(page, pageSize));
			}else {
				stores = storeRepository.findByFavoritesid(id, new PageRequest(page, pageSize));
			}
		}

		for (Store store : stores) {
			List<Image> images = imageRepository.findByNumiid((Long) store.getNumiid());
			store.setImages(images);
		}
		return stores;
	}

	@Override
	public String saveCloth(Store store) {
		storeRepository.save(store);
		Optional<Store> st = storeRepository.findById(store.getId());
		if (st != null) {
			return "保存成功";
		} else {
			return "保存失败";
		}

	}
}
