package com.shop.footer.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.shop.footer.domain.GuessLike;

public interface FooterRepository extends JpaRepository<GuessLike, Integer> {

	// 根据marktime顺序获取浏览历史
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "select *  from guesslike  where username = ?1 order by marktime", nativeQuery = true)
	List<GuessLike> findByUsername(String username);

	GuessLike findByClothesid(String clothesid);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update guesslike set marktime = ?1  where clothesid = ?2", nativeQuery = true)
	void updateMarktime(Date marktime,String clothesid);

}
