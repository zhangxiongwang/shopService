package com.shop.image.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.image.domain.Image;
import com.shop.image.repository.ImageRepository;
import com.shop.store.service.StoreService;

@Service
public class ImageServiceImpl  implements ImageService{
	@Autowired
	ImageRepository imageRepository;

	@Override
	public String saveImg(Image img) {
		imageRepository.save(img);
		return "保存成功";
	}
}
