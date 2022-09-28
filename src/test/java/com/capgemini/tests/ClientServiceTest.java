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
		Client client = new Client();
		client.setAddress("address1");
		client.setPassword("C1pass");
		client.setPhoneNumber(1234);
		service.addClient(client);
	}
		
	@Test
	@Order(2)
	@DisplayName("Adding Client2")
	public void addClientTest2() {
		Client client = new Client();
	
		client.setAddress("address2");
		client.setPassword("C2pass");
		client.setPhoneNumber(2134);
		service.addClient(client);
	}
	@Test
	@Order(3)
	@DisplayName("Adding Client3")
	public void addClientTest3() {
		
		Client client = new Client();
		client.setAddress("address3");
		client.setPassword("C3pass");
		client.setPhoneNumber(3234);
		service.addClient(client);
	}
	@Test
	@Order(4)
	@DisplayName("Adding Client4")
	public void addClientTest4() {
		
		Client client = new Client();
		client.setAddress("address4");
		client.setPassword("C4pass");
		client.setPhoneNumber(1234);
		service.addClient(client);
	}
	@Test
	@Order(5)
	@DisplayName("Adding Client5")
	public void addClientTest5() {
		
		Client client = new Client();
		client.setAddress("address5");
		client.setPassword("C5pass");
		client.setPhoneNumber(5234);
		service.addClient(client);
	}
	@Test
	@Order(6)
	@DisplayName("Adding Client6")
	public void addClientTest6() {

		
		Client client = new Client();
		client.setAddress("address6");
		client.setPassword("C6pass");
		client.setPhoneNumber(6234);
		service.addClient(client);
	}
	@Test
	@Order(7)
	@DisplayName("Adding Client7")
	public void addClientTest7() {
		
		Client client = new Client();
		client.setAddress("address7");
		client.setPassword("C7pass");
		client.setPhoneNumber(7234);
		service.addClient(client);
	}
	@Test
	@Order(8)
	@DisplayName("Adding Client8")
	public void addClientTest8() {
		
		Client client = new Client();
		client.setAddress("address8");
		client.setPassword("C8pass");
		client.setPhoneNumber(8234);
		service.addClient(client);
	}
	@Test
	@Order(9)
	@DisplayName("Adding Client9")
	public void addClientTest9() {
		
		Client client = new Client();
		client.setAddress("address9");
		client.setPassword("C9pass");
		client.setPhoneNumber(9234);
		service.addClient(client);
	}
	@Test
	@Order(10)
	@DisplayName("Adding Client10")
	public void addClientTest10() {
		
		Client client = new Client();
		client.setAddress("address10");
		client.setPassword("C10pass");
		client.setPhoneNumber(1324);
		service.addClient(client);
	}
	@Test
	@Order(11)
	@DisplayName("Adding Client11")
	public void addClientTest11() {
		
		Client client = new Client();
		client.setAddress("address11");
		client.setPassword("C11pass");
		client.setPhoneNumber(3134);
		service.addClient(client);
	}
	@Test
	@Order(12)
	@DisplayName("Adding Client12")
	public void addClientTest12() {
		
		Client client = new Client();
		client.setAddress("address12");
		client.setPassword("C12pass");
		client.setPhoneNumber(1235);
		service.addClient(client);
	}
	@Test
	@Order(13)
	@DisplayName("Adding Client13")
	public void addClientTest13() {
		
		Client client = new Client();
		client.setAddress("address13");
		client.setPassword("C13pass");
		client.setPhoneNumber(1284);
		service.addClient(client);
	}
	@Test
	@Order(14)
	@DisplayName("Adding Client14")
	public void addClientTest14() {
		
		Client client = new Client();
		client.setAddress("address14");
		client.setPassword("C14pass");
		client.setPhoneNumber(1236);
		service.addClient(client);
	}
	@Test
	@Order(15)
	@DisplayName("Adding Client15")
	public void addClientTest15() {
		
		Client client = new Client();
		client.setAddress("address");
		client.setPassword("C15pass");
		client.setPhoneNumber(1267);
		service.addClient(client);
	}


	@Test
	@Order(16)
	@DisplayName("Searching Client")
	public void getClientTest() {
		service.getClientByClientId(1);
	}

}
