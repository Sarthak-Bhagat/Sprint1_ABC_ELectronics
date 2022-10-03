package com.capgemini.tests;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.services.AdminService;
import com.capgemini.services.ClientService;
import com.capgemini.services.ComplaintService;
import com.capgemini.services.ProductService;

@DisplayName("Tests for inserting data into tables")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class InsertionTests {

	@Autowired
	ClientService cService;

	@Autowired
	ProductService pService;

	@Autowired
	AdminService aService;

	@Autowired
	ComplaintService complaintService;

	@Test
	@Order(2)
	@DisplayName("Adding Clients")
	public void addClientTest1() {
		Client client1 = new Client("address1", "C1pass", 1234);
		Client client2 = new Client("address2", "C2pass", 2134);
		Client client3 = new Client("address3", "C3pass", 3234);
		Client client4 = new Client("address4", "C4pass", 1234);
		Client client5 = new Client("address5", "C5pass", 5234);
		Client client6 = new Client("address6", "C6pass", 6234);
		Client client7 = new Client("address7", "C7pass", 7234);
		Client client8 = new Client("address8", "C8pass", 8234);
		Client client9 = new Client("address9", "C9pass", 9234);
		Client client10 = new Client("address10", "C10pass", 1324);

		cService.addClient(client1);
		cService.addClient(client2);
		cService.addClient(client3);
		cService.addClient(client4);
		cService.addClient(client5);
		cService.addClient(client6);
		cService.addClient(client7);
		cService.addClient(client8);
		cService.addClient(client9);
		cService.addClient(client10);
	}

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

		aService.addEngineer(Engineer1);
		aService.addEngineer(Engineer2);
		aService.addEngineer(Engineer3);
		aService.addEngineer(Engineer4);
		aService.addEngineer(Engineer5);
		aService.addEngineer(Engineer6);
		aService.addEngineer(Engineer7);
		aService.addEngineer(Engineer8);
		aService.addEngineer(Engineer9);
		aService.addEngineer(Engineer10);
	}

	@Test
	@Order(3)
	@DisplayName("Adding Products")
	public void addProductTest1() {
		Product product1 = new Product(LocalDate.now(), "Mobiles", "Samsung", LocalDate.of(2025, 4, 2));
		Product product2 = new Product(LocalDate.now(), "Laptops", "HP", LocalDate.of(2027, 2, 2));
		Product product3 = new Product(LocalDate.now(), "Computers", "Dell", LocalDate.of(2029, 3, 7));
		Product product4 = new Product(LocalDate.now(), "Printers", "Canon", LocalDate.of(2023, 11, 5));
		Product product5 = new Product(LocalDate.now(), "Mobiles", "Vivo", LocalDate.of(2027, 6, 9));
		Product product6 = new Product(LocalDate.now(), "Laptops", "Lenovo", LocalDate.of(2025, 4, 1));
		Product product7 = new Product(LocalDate.now(), "Mobiles", "Redmi", LocalDate.of(2022, 12, 8));
		Product product8 = new Product(LocalDate.now(), "Laptops", "Asus", LocalDate.of(2022, 12, 7));
		Product product9 = new Product(LocalDate.now(), "Printers", "Epson", LocalDate.of(2023, 5, 8));
		Product product10 = new Product(LocalDate.now(), "Mobiles", "Apple", LocalDate.of(2024, 1, 2));
		Product product11 = new Product(LocalDate.now(), "Mobiles", "Blackberry", LocalDate.of(2000, 1, 2));

		pService.addProduct(product1);
		pService.addProduct(product2);
		pService.addProduct(product3);
		pService.addProduct(product4);
		pService.addProduct(product5);
		pService.addProduct(product6);
		pService.addProduct(product7);
		pService.addProduct(product8);
		pService.addProduct(product9);
		pService.addProduct(product10);
		pService.addProduct(product11);
	}

	@Test
	@Order(5)
	@DisplayName("Booking  complaint")
	public void bookComplaintTest() {
		complaintService.bookComplaint(1, 1, "HELP");
		complaintService.bookComplaint(3, 3, "PLEASE FIX THIS ISUUE");
		complaintService.bookComplaint(4, 4, "HELP");
		complaintService.bookComplaint(5, 5, "PLEASE FIX THIS ISUUE");
		complaintService.bookComplaint(6, 6, "PLEASE FIX THIS ISUUE");
		complaintService.bookComplaint(7, 7, "HELP");
		complaintService.bookComplaint(8, 8, "PLEASE FIX THIS ISUUE");
		complaintService.bookComplaint(9, 9, "PLEASE HELP");
	}

	@Test
	@Order(4)
	@DisplayName("Adding Products to Clients")
	public void clientAddProductTest() {
		cService.addProduct(3, 1);
		cService.addProduct(2, 2);
		cService.addProduct(4, 4);
		cService.addProduct(5, 1);

		cService.addProduct(6, 1);
		cService.addProduct(7, 2);
		cService.addProduct(8, 4);
		cService.addProduct(9, 1);

	}
}