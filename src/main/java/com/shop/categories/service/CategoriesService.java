package com.shop.categories.service;

import java.util.Map;

import com.shop.categories.domian.Categories;

public interface CategoriesService {
	Map<String,Object> getCategories();

	String saveCategories(Categories categories);
}
