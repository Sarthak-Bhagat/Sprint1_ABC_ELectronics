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
	@DisplayName("Booking 1st complaint")
	public void bookComplaintTest1() {
		service.bookComplaint(1, 1, "HELP");
		service.bookComplaint(2, 2, "PLEASE HELP");
		service.bookComplaint(3, 3, "PLEASE FIX THIS ISUUE");
		service.bookComplaint(4, 4, "HELP");
		service.bookComplaint(5, 5, "PLEASE FIX THIS ISUUE");
		service.bookComplaint(6, 6, "PLEASE FIX THIS ISUUE");
		service.bookComplaint(7, 7, "HELP");
		service.bookComplaint(8, 8, "PLEASE FIX THIS ISUUE");
		service.bookComplaint(9, 9, "PLEASE HELP");
		service.bookComplaint(10, 10, "PLEASE HELP");
	}
	
	@Test
	@Order(2)
	@DisplayName("Getting All Client Complaints")
	public void getClientAllComplaints() {
		service.getClientAllComplaints(2);
	}

	@Test
	@Order(3)
	@DisplayName("Getting All Client open Complaints")
	public void getClientAllOpenComplaints() {
		service.getClientAllOpenComplaints(2);
	}

//	@Test
//	@Order(10)
//	@DisplayName("Changing complaint status")
//	public void changeComplaintStatus() {
//		service.changeComplaintStatus(2);
//	}
//	@Test
//	@Order(11)
//	@DisplayName("Getting engineer")
//	public void getEngineer() {
//		service.getEngineer(2);
//	}
//	@Test
//	@Order(12)
//	@DisplayName("Getting engineer")
//	public void getEngineer2() {
//		service.getEngineer(4);
//	}
//	@Test
//	@Order(13)
//	@DisplayName("Getting Product")
//	public void getProduct() {
//		service.getProduct(3);
//	}
//	@Test
//	@Order(14)
//	@DisplayName("Getting Product")
//	public void getProduct2() {
//		service.getProduct(6);
//	}
//
	
}