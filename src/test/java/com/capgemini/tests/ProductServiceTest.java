package com.capgemini.tests;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Product;
import com.capgemini.services.ProductService;

@DisplayName("Product Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService service;

	@Test
	@Order(1)
	@DisplayName("Adding Product")
	public void addEngineerTest() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("Food");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	}

}
