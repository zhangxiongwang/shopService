package com.shop.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.shop.address.domain.ShopAddress;

public interface ShopAddressRepository extends JpaRepository<ShopAddress, Integer> {
	// 获取全部地址
	List<ShopAddress> findByUsername(String username);

	// 获取选中地址
	ShopAddress findByDefultAndUsername(Boolean defult, String username);

	// 更新选中地址
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update address  set defult = ?1 where id = ?2 and username = ?3", nativeQuery = true)
	int updateDefult(Boolean defult, Integer id, String username);
}
