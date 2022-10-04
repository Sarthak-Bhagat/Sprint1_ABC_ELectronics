package com.capgemini.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginDetails;
import com.capgemini.services.ClientServiceImpl;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientServiceImpl service;

	@PostMapping("/register")
	public ResponseEntity<String> addClient(@RequestBody Client client, HttpServletRequest request) {

		service.addClient(client);
		return new ResponseEntity<String>("Please go to /login to log in", HttpStatus.ACCEPTED);
	}

	@PutMapping("/buyproduct/{modelNumber}")
	public ResponseEntity<Product> buyProduct(@PathVariable long modelNumber, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");

		return new ResponseEntity<Product>(service.addProduct(modelNumber, currentUser.getUserId()), HttpStatus.OK);
	}

	private boolean checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
			System.out.println(currentUser);
			if (currentUser.isClient()) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@GetMapping("/get")
	public ResponseEntity<Client> getClientByClientId(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
		return new ResponseEntity<Client>(service.getClientByClientId(currentUser.getUserId()), HttpStatus.OK);
	}

	@GetMapping("/getengineer/{complaintId}")
	public Engineer getEngineerByComplaintId(@PathVariable long complaintId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getEngineerByComplaintId(complaintId);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDetails loginDetails, HttpServletRequest request) {

		if (service.login(loginDetails.getUserId(), loginDetails.getPassword())) {

			HttpSession session = request.getSession(true);
			loginDetails.setClient(true);
			session.setAttribute("userDetails", loginDetails);
			return new ResponseEntity<String>("LOGGED IN", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.FORBIDDEN);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logOut(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.FORBIDDEN);
		}

		HttpSession session = request.getSession(true);
		LoginDetails loginDetails = (LoginDetails) session.getAttribute("userDetails");
		loginDetails.setAdmin(false);
		session.setAttribute("userDetails", loginDetails);
		return new ResponseEntity<String>("LOGGED OUT", HttpStatus.FOUND);
	}

}
