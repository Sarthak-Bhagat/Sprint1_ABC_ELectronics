package com.capgemini.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.exceptions.InvalidModelNumberException;
import com.capgemini.services.ProductService;

@DisplayName("Product Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService service;

	@Test
	@DisplayName("get engineers")
	public void getEngineersTest() {

		// only complain query executed
		service.getEngineers(1);

	}

	@Test
	@DisplayName("get Product complaints")
	public void getProductComplaintsTest() {

		service.getProductComplaints(1);

	}

	@Test
	@DisplayName("get all Product")
	public void getProductsTest() {

		service.getProducts();

	}

	@Test
	@DisplayName("Invalid Test Invalid model number while remove product")
	public void invalidTest() {

		Assertions.assertThrows(InvalidModelNumberException.class, () -> {
			service.removeProduct(100000);
		});

	}

	@Test
	@DisplayName("Remove Product")
	public void removeProductTest() {
		service.removeProduct(2);

	}

}
