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
import com.capgemini.services.EngineerService;

@DisplayName("Engineer Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class EngineerServiceTest {

	@Autowired
	EngineerService service;

	@Test
	@DisplayName("Engineer Login")
	public void adminLoginTest() {
		service.login(1, "E1 pass");
	}

	@Test
	@DisplayName("All Open Complaints")
	public void getAllOpenComplaints() {
		service.getAllOpenComplaints(1);
	}

	@Test
	@DisplayName("All Resolved Complaints")
	public void getResolvedComplaints() {
		service.getResolvedComplaints(1);
	}

	@Test
	@DisplayName("Invalid Engineer Login")
	public void invalidAdminLoginTest() {
		assertThrows(InvalidCredentialsException.class, () -> {
			service.login(1, "Wrong Pass");
		});
	}

	@Test
	@DisplayName("Invalid Open Complaints")
	public void invalidGetAllOpenComplaints() {
		service.getAllOpenComplaints(1);
		assertThrows(InvalidEngineerIdException.class, () -> {
			service.getAllOpenComplaints(100);
		});
	}

	@Test
	@DisplayName("Invalid Resolved Complaints")
	public void invalidGetResolvedComplaints() {
		service.getAllOpenComplaints(1);
		assertThrows(InvalidEngineerIdException.class, () -> {
			service.getResolvedComplaints(1000);
		});
	}

}
