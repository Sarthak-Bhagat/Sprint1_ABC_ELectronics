package com.capgemini.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Admin;
import com.capgemini.entities.Client;
import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginDetails;
import com.capgemini.services.AdminService;
import com.capgemini.services.ClientServiceImpl;
import com.capgemini.services.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService service;

	@Autowired
	ProductService pService;

	@Autowired
	ClientServiceImpl cService;

	@PostMapping("/add")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		service.addAdmin(admin);
		return new ResponseEntity<String>("ADDED ADMIN", HttpStatus.OK);
	}

	@PostMapping("/client/add")
	public ResponseEntity<String> addClient(@RequestBody Client client, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		cService.addClient(client);
		return new ResponseEntity<String>("ADDED CLIENT", HttpStatus.OK);
	}

	@PostMapping("/engineer/add")
	public ResponseEntity<String> addEngineer(@RequestBody Engineer engineer, HttpServletRequest request) {

		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		service.addEngineer(engineer);
		return new ResponseEntity<String>("ADDED ENGINEER", HttpStatus.OK);
	}

	@PostMapping("/product/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		pService.addProduct(product);
		return new ResponseEntity<String>("ADDED PRODUCT", HttpStatus.OK);
	}

	private boolean checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
			if (currentUser.isAdmin()) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@GetMapping("/engineer/get/all")
	public List<Engineer> getAllEngineers(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getEngineers();
	}

	@GetMapping("/client/get/all")
	public ResponseEntity<List<Client>> getClients(HttpServletRequest request) {

		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		List<Client> clients = service.getClients();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	@GetMapping("/complaint/get/all")
	public ResponseEntity<List<Complaint>> getComplaints(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		List<Complaint> complaints = service.getComplaints();
		System.out.println(complaints);
		return new ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
	}

	@GetMapping("/complaint/product/{modelNumber}")
	public ResponseEntity<List<Complaint>> getComplaintsByProducts(@PathVariable long modelNumber,
			HttpServletRequest request) {

		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return new ResponseEntity<List<Complaint>>(service.getComplaintsByProducts(modelNumber), HttpStatus.OK);
	}

	@DeleteMapping("/engineer/remove/{engineerId}")
	public ResponseEntity<String> removeEngineer(@PathVariable long engineerId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		service.removeEngineer(engineerId);
		return new ResponseEntity<String>("REMOVED ENGINEER", HttpStatus.OK);

	}

	@DeleteMapping("/product/remove/{modelNumber}")
	public ResponseEntity<String> removeProduct(@PathVariable long modelNumber, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		pService.removeProduct(modelNumber);
		return new ResponseEntity<String>("REMOVED PRODUCT", HttpStatus.OK);

	}

	@PatchMapping("/complaint/replacein/{complaintId}/by/{engineerId}")
	public ResponseEntity<String> replaceEmployeeFromComplaint(@PathVariable long engineerId,
			@PathVariable long complaintId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		// TODO Exception
		service.replaceEmployeeFromComplaint(engineerId, complaintId);
		return new ResponseEntity<String>("EMPLOYEE REPLACED", HttpStatus.FORBIDDEN);
	}

	@PostMapping("/login")
	public ResponseEntity<String> signIn(@RequestBody LoginDetails loginDetails, HttpServletRequest request) {

		// TODO You're already logged in
		if (service.login(loginDetails.getUserId(), loginDetails.getPassword())) {

			HttpSession session = request.getSession(true);
			loginDetails.setAdmin(true);
			session.setAttribute("userDetails", loginDetails);
			return new ResponseEntity<String>("LOGGED IN", HttpStatus.OK);
		}
		return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.FORBIDDEN);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> signout(HttpServletRequest request) {
		boolean validLogin = checkSession(request);
		if (!validLogin) {
			return new ResponseEntity<String>("USER NOT LOGGED IN", HttpStatus.FORBIDDEN);
		}

		HttpSession session = request.getSession(true);
		LoginDetails loginDetails = (LoginDetails) session.getAttribute("userDetails");
		loginDetails.setAdmin(false);
		session.setAttribute("userDetails", loginDetails);
		return new ResponseEntity<String>("LOGGED OUT", HttpStatus.FOUND);
	}

	@PatchMapping("/updateWarranty/{modelNumber}/{warrantyYears}")
	public ResponseEntity<String> updateProductWarranty(@PathVariable long warrantyYears,
			@PathVariable long modelNumber, HttpServletRequest request) {
		boolean validLogin = checkSession(request);
		if (!validLogin) {
			return new ResponseEntity<String>("USER NOT LOGGED IN", HttpStatus.FORBIDDEN);
		}
		pService.updateProductWarranty(warrantyYears, modelNumber);
		return new ResponseEntity<String>("WARRANTY UPDATED", HttpStatus.OK);
	}
}
