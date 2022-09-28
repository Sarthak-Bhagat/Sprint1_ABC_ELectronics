package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
