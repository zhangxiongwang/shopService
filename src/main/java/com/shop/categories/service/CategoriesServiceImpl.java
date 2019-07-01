package com.shop.categories.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.categories.domian.Categories;
import com.shop.categories.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	CategoriesRepository categoriesRepository;

	@Override
	public Map<String, Object> getCategories() {
		List<Categories> categories = categoriesRepository.findAll();
	    Map<String, Object> result = new HashMap<String, Object>();
	    result.put("data", categories);
		return result;
	} 

	@Override
	public String saveCategories(Categories categories) {
		categoriesRepository.save(categories);
		return "保存成功";

	}
}
