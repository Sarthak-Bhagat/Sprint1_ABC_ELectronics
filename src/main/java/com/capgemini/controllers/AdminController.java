package com.capgemini.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Client;
import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginCreds;
import com.capgemini.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("/engineer/add")
	public ResponseEntity<String> addEngineer(@RequestBody Engineer engineer) {
		service.addEngineer(engineer);
		List<Complaint> complaints = service.getComplaints();
		System.out.println(complaints);
		return new ResponseEntity<String>("ADDED ENGINEER", HttpStatus.ACCEPTED);
	}

	private boolean checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();

		boolean validLogin = false;
		Optional<Boolean> nullable = Optional.ofNullable((boolean) session.getAttribute("admin"));
		if (nullable.isPresent() && (boolean) session.getAttribute("admin")) {
			validLogin = true;
		}
		return validLogin;
	}

	@GetMapping("/client/get/all")
	public ResponseEntity<List<Client>> getClients(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new RuntimeException("Invalid user Click here to <a href = 'loginpageURL'>Login</a> ");
		}
		List<Client> clients = service.getClients();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	@GetMapping("/complaint/all")
	@ResponseBody
	public ResponseEntity<List<Complaint>> getComplaints() {
		List<Complaint> complaints = service.getComplaints();
		System.out.println(complaints);
		return new ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
//		return service.getComplaints();
	}

	@GetMapping("/complaint/{modelNumber}")
	public List<Complaint> getComplaintsByProducts(@PathVariable long modelNumber) {
		return service.getComplaintsByProducts(modelNumber);
	}

	@GetMapping("/engineer/get/all")
	public ResponseEntity<List<Engineer>> getEngineers() {
		List<Engineer> engineers = service.getEngineers();
		return new ResponseEntity<List<Engineer>>(engineers, HttpStatus.OK);
	}

	@GetMapping("/engineer/remove/{engineerId}")
	public ResponseEntity<String> removeEngineer(@PathVariable long engineerId) {
		service.removeEngineer(engineerId);
		return new ResponseEntity<String>("REMOVED ENGINEER", HttpStatus.OK);

	}

	@GetMapping("/complaint/{engineerId}/{complaintId}")
	public void replaceEmployeeFromComplaint(@PathVariable long engineerId, @PathVariable long complainId) {
		service.replaceEmployeeFromComplaint(engineerId, complainId);
	}

	@PostMapping("/signin")
	public void signInWithCredentials(@RequestBody LoginCreds creds, HttpServletRequest request) {

		long username = creds.getUserId();
		String password = creds.getPassword();

		if (service.login(username, password)) {

			HttpSession session = request.getSession(true);

			session.setAttribute("admin", true);
		} else {
			throw new InvalidCredentialsException();
		}

	}

}
