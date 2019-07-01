package com.shop.categories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.categories.domian.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, String> {

}
