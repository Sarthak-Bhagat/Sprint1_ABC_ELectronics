package com.capgemini.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Client;
import com.capgemini.services.ClientService;

@DisplayName("Client Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ClientServiceTest {

	@Autowired
	ClientService service;

	@Test
	@Order(1)
	@DisplayName("Adding Client")
	public void addClientTest() {
		Client client = new Client();
		client.setAddress("Home");
		client.setPassword("pass");
		client.setPhoneNumber(1234);
		service.addClient(client);
	}

	@Test
	@Order(2)
	@DisplayName("Serching Client")
	public void getClientTest() {
		service.getClientByClientId(1);
	}

}
