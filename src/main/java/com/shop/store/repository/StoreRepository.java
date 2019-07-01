package com.shop.store.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.store.domian.Store;

public interface StoreRepository extends JpaRepository<Store, String> {
	Page<Store> findByFavoritesid(Long favoritesid, Pageable page);

	Page<Store> findByFavoritesidOrderByIdDesc(Long id, Pageable page);

	Page<Store> findByFavoritesidOrderByZkfinalpriceAsc(Long id, Pageable pageRequest);

	Page<Store> findByFavoritesidOrderByZkfinalpriceDesc(Long id, Pageable pageRequest);

}
