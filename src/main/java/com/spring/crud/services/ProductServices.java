package com.spring.crud.services;

import java.util.List;

import com.spring.crud.model.Product;

public interface ProductServices {

	Product saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(long id);

	Product updateProduct(Product Product, long id);

	void deleteProduct(long id);

}