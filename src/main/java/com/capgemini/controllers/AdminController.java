package com.capgemini.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/client/add")
	public ResponseEntity<String> addClient(@RequestBody Client client, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		cService.addClient(client);
		return new ResponseEntity<String>("ADDED CLIENT", HttpStatus.ACCEPTED);
	}

	@PostMapping("/engineer/add")
	public ResponseEntity<String> addEngineer(@RequestBody Engineer engineer, HttpServletRequest request) {

		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		service.addEngineer(engineer);
		return new ResponseEntity<String>("ADDED ENGINEER", HttpStatus.ACCEPTED);
	}

	@PostMapping("/product/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		pService.addProduct(product);
		return new ResponseEntity<String>("ADDED PRODUCT", HttpStatus.ACCEPTED);
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

	@GetMapping("/engineer/remove/{engineerId}")
	public ResponseEntity<String> removeEngineer(@PathVariable long engineerId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		service.removeEngineer(engineerId);
		return new ResponseEntity<String>("REMOVED ENGINEER", HttpStatus.OK);

	}

	@GetMapping("/complaint/{engineerId}/{complaintId}")
	public void replaceEmployeeFromComplaint(@PathVariable long engineerId, @PathVariable long complainId,
			HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}

		service.replaceEmployeeFromComplaint(engineerId, complainId);
	}

	@PostMapping("/login")
	public ResponseEntity<String> signIn(@RequestBody LoginDetails loginDetails, HttpServletRequest request) {

		if (service.login(loginDetails.getUserId(), loginDetails.getPassword())) {

			HttpSession session = request.getSession(true);
			loginDetails.setAdmin(true);
			session.setAttribute("userDetails", loginDetails);
			return new ResponseEntity<String>("LOGGED IN", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND);
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
}
