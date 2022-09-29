package com.capgemini.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.services.EngineerService;

@DisplayName("Engineer Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class EngineerServiceTest {

	@Autowired
	EngineerService service;

	
	@Test
	@Order(1)
	@DisplayName("All Open Complaints")
	public void getAllOpenComplaints() {
		service.getAllOpenComplaints(1);
	}
	@Test
	@Order(2)
	@DisplayName("All Open Complaints")
	public void getResolvedComplaints() {
		service.getResolvedComplaints(1);
	}
	@Test
	@Order(2)
	@DisplayName("All Open Complaints")
	public void getEngineers() {
		service.getEngineers();
	}

}
