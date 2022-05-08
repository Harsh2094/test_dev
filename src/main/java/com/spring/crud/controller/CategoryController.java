package com.spring.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.Category;
import com.spring.crud.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryServices categoryServices;

	public CategoryController(CategoryServices categoryServices) {
		super();
		this.categoryServices = categoryServices;
	}

	// Build create employee API
	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryServices.saveCategory(category), HttpStatus.CREATED);

	}

	// Build get all employee API

	@GetMapping
	public List<Category> getCategory() {

		return categoryServices.getAllCategories();
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
		return new ResponseEntity<Category>(categoryServices.getCategoryById(id), HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Category> updateEmployeeById(@PathVariable("id") long id, @RequestBody Category category) {

		return new ResponseEntity<Category>(categoryServices.updateCategory(category, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id) {
		categoryServices.deleteCategory(id);
		return new ResponseEntity<String>("Category Deleted Successfully", HttpStatus.OK);
	}

}
