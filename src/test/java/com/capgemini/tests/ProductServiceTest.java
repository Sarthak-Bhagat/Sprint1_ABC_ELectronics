package com.capgemini.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidModelNumberException;
import com.capgemini.services.ProductService;

@DisplayName("Product Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService service;

	@Test
	@Order(1)
	@DisplayName("Adding Product ")
	public void addProductTest1() {
		Product product1 = new Product(LocalDate.now(), "Mobiles", "Samsung", LocalDate.of(2025, 4, 2));
		Product product2 = new Product(LocalDate.now(), "Laptops", "HP", LocalDate.of(2027, 2, 2));
		Product product3 = new Product(LocalDate.now(), "Computers", "Dell", LocalDate.of(2029, 3, 7));
		Product product4 = new Product(LocalDate.now(), "Printers", "Canon", LocalDate.of(2023, 11, 5));
		Product product5 = new Product(LocalDate.now(), "Mobiles", "Vivo", LocalDate.of(2027, 6, 9));
		Product product6 = new Product(LocalDate.now(), "Laptops", "Lenovo", LocalDate.of(2025, 4, 1));
		Product product7 = new Product(LocalDate.now(), "Mobiles", "Redmi", LocalDate.of(2022, 12, 8));
		Product product8 = new Product(LocalDate.now(), "Laptops", "Asus", LocalDate.of(2022, 12, 7));
		Product product9 = new Product(LocalDate.now(), "Printers", "Epson", LocalDate.of(2023, 5, 8));
		Product product10 = new Product(LocalDate.now(), "Mobiles", "Apple", LocalDate.of(2024, 1, 2));

		service.addProduct(product1);
		service.addProduct(product2);
		service.addProduct(product3);
		service.addProduct(product4);
		service.addProduct(product5);
		service.addProduct(product6);
		service.addProduct(product7);
		service.addProduct(product8);
		service.addProduct(product9);
		service.addProduct(product10);
		// TODO Test cases for out of warranty
	}

	@Test
	@Order(2)
	@DisplayName("Invalid Test ")
	public void invalidTest() {

		assertThrows(InvalidModelNumberException.class, () -> {
			service.removeProduct(100000);
		});

	}

}
