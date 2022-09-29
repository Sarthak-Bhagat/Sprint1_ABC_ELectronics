package com.capgemini.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidEngineerIdException;
import com.capgemini.services.AdminService;

@DisplayName("Admin Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AdminServiceTest {

	@Autowired
	AdminService service;

	@Test
	@Order(1)
	@DisplayName("Adding Engineers")
	public void addEngineerTest1() {
		Engineer Engineer1 = new Engineer("E1", "E1 pass");
		Engineer Engineer2 = new Engineer("E2", "E2 pass");
		Engineer Engineer3 = new Engineer("E3", "E3 pass");
		Engineer Engineer4 = new Engineer("E4", "E4 pass");
		Engineer Engineer5 = new Engineer("E5", "E5 pass");
		Engineer Engineer6 = new Engineer("E6", "E6 pass");
		Engineer Engineer7 = new Engineer("E7", "E7 pass");
		Engineer Engineer8 = new Engineer("E8", "E8 pass");
		Engineer Engineer9 = new Engineer("E9", "E9 pass");
		Engineer Engineer10 = new Engineer("E10", "E10 pass");

		service.addEngineer(Engineer1);
		service.addEngineer(Engineer2);
		service.addEngineer(Engineer3);
		service.addEngineer(Engineer4);
		service.addEngineer(Engineer5);
		service.addEngineer(Engineer6);
		service.addEngineer(Engineer7);
		service.addEngineer(Engineer8);
		service.addEngineer(Engineer9);
		service.addEngineer(Engineer10);
	}

	@Test
	@Order(3)
	@DisplayName("Get Clients")
	public void getClientsTest() {
		service.getEngineerById(5);
	}

	@Test
	@Order(4)
	@DisplayName("Get Complaints")
	public void getComplaints() {
		service.getComplaints();
	}

	@Test
	@Order(5)
	@DisplayName("Get ComplaintsByProducts")
	public void getComplaintsByProducts() {
		service.getComplaintsByProducts(2);
	}

	@Test
	@Order(5)
	@DisplayName("Check InvalidEmployeeIdException")
	public void invalidIdTest() {
		assertThrows(InvalidEngineerIdException.class, () -> {
			service.removeEngineer(100000);
		});
	}

	@Test
	@Order(2)
	@DisplayName("Remove Engineer")
	public void removeEngineerTest() {
		service.removeEngineer(2);
	}

}
