package com.spring.crud.services;

import java.util.List;

import com.spring.crud.model.Category;

public interface CategoryServices {

	Category saveCategory(Category category);

	List<Category> getAllCategories();

	Category getCategoryById(long id);

	Category updateCategory(Category category, long id);

	void deleteCategory(long id);

}