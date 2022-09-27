package com.capgemini.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Engineer;
import com.capgemini.services.AdminService;

@DisplayName("Admin Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AdminServiceTest {

	@Autowired
	AdminService service;

	@Test
	@Order(1)
	@DisplayName("Adding Engineer")
	public void addEngineerTest() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("CA");
		engineer.setPassword("Hello");
		service.addEngineer(engineer);
	}

}
