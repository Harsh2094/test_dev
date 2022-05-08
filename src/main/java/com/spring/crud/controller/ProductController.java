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

import com.spring.crud.model.Product;
import com.spring.crud.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductServices productServices;

	public ProductController(ProductServices productServices) {
		super();
		this.productServices = productServices;
	}

	// Build create employee API
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productServices.saveProduct(product), HttpStatus.CREATED);

	}

	// Build get all employee API

	@GetMapping
	public List<Product> getCategory() {

		return productServices.getAllProducts();
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		return new ResponseEntity<Product>(productServices.getProductById(id), HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable("id") long id, @RequestBody Product product) {

		return new ResponseEntity<Product>(productServices.updateProduct(product, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") long id) {
		productServices.deleteProduct(id);
		return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
	}

}


