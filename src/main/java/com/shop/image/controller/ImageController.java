package com.shop.image.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.image.domain.Image;
import com.shop.image.service.ImageService;

@RestController
public class ImageController {
	@Autowired
	ImageService imageService;

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveimg(@RequestBody Image img) {
		return imageService.saveImg(img);
	}

}
