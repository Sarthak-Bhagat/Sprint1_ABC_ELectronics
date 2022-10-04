package com.capgemini.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.OutOfWarrantyException;
import com.capgemini.services.ComplaintService;

@DisplayName("Complaint Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ComplaintServiceTest {

	@Autowired
	ComplaintService service;

	@Test
	@DisplayName("Client Login")
	public void adminLoginTest() {
		service.login(1, "C1pass");
	}

	@Test
	@Order(1)
	@DisplayName("Status set to resolved")
	public void changeStatusTest() {

		Assertions.assertEquals("The complaint has been set to resolved", service.changeComplaintStatus(1));

	}

	@Test
	@Order(2)
	@DisplayName("Status set to open")
	public void changeStatusTest2() {
		// Resolved
		Assertions.assertEquals("The complaint has been set to open", service.changeComplaintStatus(1));

	}

	@Test
	@Order(3)
	@DisplayName("Status set to resolved")
	public void changeStatusTest3() {
		// Check status Resolved in DB
		Assertions.assertEquals("The complaint has been set to resolved", service.changeComplaintStatus(2));

	}

	@Test
	@DisplayName("Client Login")
	public void clientLoginTest() {
		service.login(1, "C1pass");
	}

	@Test
	@DisplayName("Getting All Client Complaints")
	public void getClientAllComplaints() {
		service.getClientAllComplaints(1);

	}

	@Test
	@DisplayName("Getting All Client open Complaints")
	public void getClientAllOpenComplaintsTest() {
		// System.out.println(service.getClientAllOpenComplaints(1));
		service.getClientAllOpenComplaints(1);
	}

	@Test
	@DisplayName("Getting Engineer by ClientId")
	public void getEngineerTest() {

		// System.out.println(service.getEngineer(1));
		service.getEngineer(1);
	}

	@Test
	@DisplayName("Getting Product")
	public void getProductTest() {

		// System.out.println(service.getEngineer(1));
		service.getProduct(1);
	}

	@Test
	@DisplayName("Invalid Client Login")
	public void invalidClientLoginTest() {
		assertThrows(InvalidCredentialsException.class, () -> {
			service.login(1, "Wrong Pass");
		});
	}

	@Test
	@DisplayName("Check if out of warranty error is thrown")
	public void warrantyTest() {
		Assertions.assertThrows(OutOfWarrantyException.class, () -> {
			service.bookComplaint(7, 12, "Too old");
		});

	}

}