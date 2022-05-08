package com.spring.crud.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.exception.ResourceNotFoundException;
import com.spring.crud.model.Category;
import com.spring.crud.repository.CategoryRepository;
import com.spring.crud.services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {

	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category saveCategory(Category category) {

		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {

		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(long id) {

		/*
		 * Optional<Employee> employee = employeeRepository.findById(id); if
		 * (employee.isPresent()) { return employee.get(); } else { throw new
		 * ResourceNotFoundException("Employee", "Id", id); }
		 */

		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
	}

	@Override
	public Category updateCategory(Category category, long id) {

		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		existingCategory.setCategoryName(category.getCategoryName());
		existingCategory.setProducts(category.getProducts());

		categoryRepository.save(existingCategory);

		return existingCategory;
	}

	@Override
	public void deleteCategory(long id) {

		categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
		categoryRepository.deleteById(id);
	}
}
