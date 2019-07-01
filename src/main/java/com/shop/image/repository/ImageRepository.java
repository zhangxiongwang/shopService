package com.shop.image.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.image.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	List<Image> findByNumiid(Long numiid);

}
