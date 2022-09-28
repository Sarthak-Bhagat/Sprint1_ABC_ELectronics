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
	@DisplayName("Adding Engineer1")
	public void addEngineerTest() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E1");
		engineer.setPassword("E1password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(2)
	@DisplayName("Adding Engineer2")
	public void addEngineerTest2() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E2");
		engineer.setPassword("E2password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(3)
	@DisplayName("Adding Engineer3")
	public void addEngineerTest3() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E3");
		engineer.setPassword("E3password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(4)
	@DisplayName("Adding Engineer4")
	public void addEngineerTest4() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E4");
		engineer.setPassword("E4password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(5)
	@DisplayName("Adding Engineer5")
	public void addEngineerTest5() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E5");
		engineer.setPassword("E5password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(6)
	@DisplayName("Adding Engineer6")
	public void addEngineerTest6() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E6");
		engineer.setPassword("E6password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(7)
	@DisplayName("Adding Engineer7")
	public void addEngineerTest7() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E7");
		engineer.setPassword("E7password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(8)
	@DisplayName("Adding Engineer8")
	public void addEngineerTest8() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E8");
		engineer.setPassword("E8password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(9)
	@DisplayName("Adding Engineer9")
	public void addEngineerTest9() {
		Engineer engineer = new Engineer();
		engineer.setEngineerName("E9");
		engineer.setPassword("E9password");
		service.addEngineer(engineer);
	}
	@Test
	@Order(10)
	@DisplayName("Remove Engineer")
	public void removeEngineerTest() {
		service.removeEngineer(14);
	}

}
