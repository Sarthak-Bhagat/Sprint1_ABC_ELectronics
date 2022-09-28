package com.capgemini.tests;

import java.time.LocalDate;
import java.util.List;

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
	@DisplayName("Adding Product 1")
	public void addProductTest1() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("Food");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
				
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Adding Product 2")
	public void addProductTest2() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Book");
		product.setProductName("The Blue Umbrella");
		product.setWarrantyDate(LocalDate.of(2022, 9, 8));
		product.setWarrentyYears(5);		
		service.addProduct(product);
		
	}
	
	@Test
	@Order(3)
	@DisplayName("Adding Product 3")
	public void addProductTest3() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Sports");
		product.setProductName("Bat");
		product.setWarrantyDate(LocalDate.of(2020, 1, 3));
		product.setWarrentyYears(1);
		service.addProduct(product);
	}
	
	@Test
	@Order(4)
	@DisplayName("Adding Product 4")
	public void addProductTest4() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Electronics");
		product.setProductName("Watch");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	
	}
	
	@Test
	@Order(5)
	@DisplayName("Adding Product 5")
	public void addProductTest5() {

		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Sports");
		product.setProductName("Stumps");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	
	}
	
	@Test
	@Order(6)
	@DisplayName("Adding Product 6")
	public void addProductTest6() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("Breakfast");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	
	}
	
	@Test
	@Order(7)
	@DisplayName("Adding Product 7")
	public void addProductTest7() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Electronics");
		product.setProductName("Laptop");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);		
		service.addProduct(product);
		
		
	}
	
	@Test
	@Order(8)
	@DisplayName("Adding Product 8")
	public void addProductTest8() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Electronics");
		product.setProductName("PC");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	}
	
	@Test
	@Order(9)
	@DisplayName("Adding Product 9")
	public void addProductTest9() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("tiffin");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
		
	
	}
	
	@Test
	@Order(10)
	@DisplayName("Adding Product 10")
	public void addProductTest10() {

		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Electronics");
		product.setProductName("Mobile");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
		
	
	}
	@Test
	@Order(11)
	@DisplayName("Adding Product 11")
	public void addProductTest11() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("Breakfast");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	
	}
	
	@Test
	@Order(12)
	@DisplayName("Adding Product 12")
	public void addProductTest12() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Electronics");
		product.setProductName("PC");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	}
	
	@Test
	@Order(13)
	@DisplayName("Adding Product 13")
	public void addProductTest13() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("tiffin");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
		
	
	}
	
	@Test
	@Order(14)
	@DisplayName("Adding Product 14")
	public void addProductTest14() {

		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Electronics");
		product.setProductName("Mobile");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
		
	
	}
	
	@Test
	@Order(15)
	@DisplayName("Adding Product 15")
	public void addProductTest15() {
		Product product = new Product();
		product.setDateotPurchase(LocalDate.now());
		product.setProductCategoryName("Lunch");
		product.setProductName("Breakfast");
		product.setWarrantyDate(LocalDate.of(2025, 4, 2));
		product.setWarrentyYears(3);
		service.addProduct(product);
	
	}
	
	
	
	
	/*
	
	@Test
	@Order(16)
	@DisplayName("Get All Product")
	public List<Product> getProductsTest() {
		return service.getProducts();
	}
	
	@Test
	@Order(17)
	@DisplayName("Removing Product")
	public void removeProductTest() {
		service.removeProduct(3);
		
	}
	*/

}
