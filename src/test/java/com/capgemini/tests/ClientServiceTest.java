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
	@DisplayName("Adding Client1")
	public void addClientTest1() {
		Client client1 = new Client("address1", "C1pass", 1234);
		Client client2 = new Client("address2", "C2pass", 2134);
		Client client3 = new Client("address3", "C3pass", 3234);
		Client client4 = new Client("address4", "C4pass", 1234);
		Client client5 = new Client("address5", "C5pass", 5234);
		Client client6 = new Client("address6", "C6pass", 6234);
		Client client7 = new Client("address7", "C7pass", 7234);
		Client client8 = new Client("address8", "C8pass", 8234);
		Client client9 = new Client("address9", "C9pass", 9234);
		Client client10 = new Client("address10", "C10pass", 1324);

		service.addClient(client1);
		service.addClient(client2);
		service.addClient(client3);
		service.addClient(client4);
		service.addClient(client5);
		service.addClient(client6);
		service.addClient(client7);
		service.addClient(client8);
		service.addClient(client9);
		service.addClient(client10);
	}

	@Test
	@Order(2)
	@DisplayName("Product Add product to client test")
	public void clientAddProductTest() {
		service.addProduct(3, 1);
		service.addProduct(2, 2);
		service.addProduct(4, 4);
		service.addProduct(5, 1);
		
		service.addProduct(6, 1);
		service.addProduct(7, 2);
		service.addProduct(8, 4);
		service.addProduct(9, 1);
		
		service.addProduct(10, 1);

	}

	@Test
	@Order(3)
	@DisplayName("Product Add Test")
	public void clientAddProductTest1() {
		service.addProduct(1, 1);
	}

	@Test
	@Order(4)
	@DisplayName("Searching Client")
	public void getClientTest() {
		service.getClientByClientId(1);
	}
	@Test
	@Order(5)
	@DisplayName("Searching Engineer")
	public void getEngineerByComplaintId() {
		service.getEngineerByComplaintId(1);
	}

}
