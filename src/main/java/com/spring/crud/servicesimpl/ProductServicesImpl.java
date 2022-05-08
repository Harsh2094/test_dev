package com.spring.crud.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.exception.ResourceNotFoundException;
import com.spring.crud.model.Product;
import com.spring.crud.repository.ProductRepository;
import com.spring.crud.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;

	public ProductServicesImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {

		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
	}

	@Override
	public Product updateProduct(Product product, long id) {

		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

		existingProduct.setProductName(product.getProductName());

		productRepository.save(existingProduct);

		return existingProduct;
	}

	@Override
	public void deleteProduct(long id) {

		productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
		productRepository.deleteById(id);
	}
}
