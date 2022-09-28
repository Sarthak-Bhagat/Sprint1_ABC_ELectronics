package com.capgemini.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.services.ComplaintService;

@DisplayName("Complaint Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ComplaintServiceTest {

	@Autowired
	ComplaintService service;

	@Test
	@Order(1)
	@DisplayName("")
	public void bookComplaintTest() {
		service.bookComplaint(1, 1, "HELP");
	}

}
