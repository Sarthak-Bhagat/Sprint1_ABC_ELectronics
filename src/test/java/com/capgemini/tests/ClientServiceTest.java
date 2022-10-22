package com.capgemini.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.exceptions.InvalidClientIdException;
import com.capgemini.exceptions.InvalidComplaintIdException;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.ProductUnvailableException;
import com.capgemini.services.ClientService;

@DisplayName("Client Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ClientServiceTest {

	@Autowired
	ClientService service;

	@Test
	@Order(1)
	@DisplayName("Product Add Test")
	public void clientAddProductTest1() {
		service.addProduct(1, 1);
	}

	@Test
	@DisplayName("Client Login")
	public void clientLoginTest() {
		service.login(1, "C1pass");
	}

	@Test
	@DisplayName("Searching Client")
	public void getClientTest() {
		service.getClientByClientId(1);
	}

	@Test
	@Order(2)
	@DisplayName("Invalid Product Add Test")
	public void invalidClientAddProductTest1() {
		assertThrows(ProductUnvailableException.class, () -> {
			service.addProduct(1, 3);
		});
	}

	@Test
	@DisplayName("Invalid Client Login")
	public void invalidClientLoginTest() {
		assertThrows(InvalidCredentialsException.class, () -> {
			service.login(1, "Wrong Pass");
		});
	}

	@Test
	@DisplayName("Searching Client")
	public void invalidGetClientTest() {
		assertThrows(InvalidClientIdException.class, () -> {
			service.getClientByClientId(100);
		});
	}

	@Test
	@DisplayName("Searching Engineer")
	public void invalidGetEngineerByComplaintId() {
		assertThrows(InvalidComplaintIdException.class, () -> {
			service.getEngineerByComplaintId(300);
		});
	}
}
