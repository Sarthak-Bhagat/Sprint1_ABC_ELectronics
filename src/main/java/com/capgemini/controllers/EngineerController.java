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

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginDetails;
import com.capgemini.services.EngineerService;

@RestController
@RequestMapping("/engineer")
public class EngineerController {

	@Autowired
	EngineerService service;

	
	private boolean checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
			System.out.println(currentUser);
			if (currentUser.isAdmin()) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	@PostMapping("/signin")
	public void signInWithCredentials(@RequestBody LoginDetails loginDetails, HttpServletRequest request) {

		long username = loginDetails.getUserId();
		String password =loginDetails.getPassword();

		if (service.login(username, password)) {

			HttpSession session = request.getSession(true);

			session.setAttribute("engineer", true);
		} else {
			throw new InvalidCredentialsException();
		}

	}
	@GetMapping("/signout")
	public ResponseEntity<String> signout(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND);
		}

		HttpSession session = request.getSession(true);
		LoginDetails loginDetails = (LoginDetails) session.getAttribute("userDetails");
		loginDetails.setAdmin(false);
		session.setAttribute("userDetails", loginDetails);
		return new ResponseEntity<String>("LOGGED IN", HttpStatus.FOUND);
	}
	@GetMapping("/all")
	public List<Engineer> getAllEngineers(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getEngineers();
	}

	@GetMapping("/open/{engineerId}")
	public List<Complaint> getAllOpenComplaints(@PathVariable long engineerId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getAllOpenComplaints(engineerId);
	}

	@GetMapping("/resolved/{engineerId}")
	public List<Complaint> getResolvedComplaints(@PathVariable long engineerId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getResolvedComplaints(engineerId);
	}

	

}
