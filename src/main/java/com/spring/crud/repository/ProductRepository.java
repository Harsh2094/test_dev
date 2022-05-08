package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
