package com.capgemini.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.services.ClientService;

@DisplayName("Client Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ClientServiceTest {

	@Autowired
	ClientService service;

	@Test
	@DisplayName("Product Add Test")
	public void clientAddProductTest1() {
		service.addProduct(1, 1);
	}

	@Test
	@DisplayName("Searching Client")
	public void getClientTest() {
		service.getClientByClientId(1);
	}

	@Test
	@DisplayName("Searching Engineer")
	public void getEngineerByComplaintId() {
		service.getEngineerByComplaintId(3);
	}

}
