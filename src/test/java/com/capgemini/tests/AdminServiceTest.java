package com.capgemini.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.InvalidEngineerIdException;
import com.capgemini.services.AdminService;

@DisplayName("Admin Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AdminServiceTest {

	@Autowired
	AdminService service;

	@Test
	@DisplayName("Admin Login")
	public void adminLoginTest() {
		service.login(1, "Admin Pass");
	}

	@Test
	@DisplayName("Get Clients")
	public void getClientsTest() {
		service.getEngineerById(5);
	}

	@Test
	@DisplayName("Get Complaints")
	public void getComplaints() {
		service.getComplaints();
	}

	@Test
	@DisplayName("Get ComplaintsByProducts")
	public void getComplaintsByProducts() {
		service.getComplaintsByProducts(3);
	}

	@Test
	@DisplayName("Invalid Admin Login")
	public void invalidAdminLoginTest() {
		assertThrows(InvalidCredentialsException.class, () -> {
			service.login(1, "Wrong Pass");
		});
	}

	@Test
	@DisplayName("Check InvalidEmployeeIdException")
	public void invalidIdTest() {
		assertThrows(InvalidEngineerIdException.class, () -> {
			service.removeEngineer(100000);
		});
	}

	@Test
	@DisplayName("Remove Engineer")
	public void removeEngineerTest() {
		service.removeEngineer(2);
	}

}
