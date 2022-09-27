package com.capgemini.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	List<Product> findAllProducts();

	Product getProductByModelNumber(int modelNumber);
}
