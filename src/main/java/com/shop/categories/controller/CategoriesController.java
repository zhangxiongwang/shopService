package com.shop.categories.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.categories.domian.Categories;
import com.shop.categories.service.CategoriesService;

@RestController
public class CategoriesController {
	@Autowired
	CategoriesService categoriesService;

	@RequestMapping(value = "/getcategories", method = RequestMethod.GET)
	public Map<String, Object> getcategories() {
		return categoriesService.getCategories();
	}

	@RequestMapping(value = "/savecategories", method = RequestMethod.POST)
	public String saveCategories(@RequestBody Categories categories) {
		return categoriesService.saveCategories(categories);
	}
}
