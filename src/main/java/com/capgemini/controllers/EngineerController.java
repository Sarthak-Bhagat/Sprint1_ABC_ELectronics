package com.capgemini.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
			if (currentUser.isEngineer()) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@GetMapping("/open")
	public List<Complaint> getAllOpenComplaints(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");

		return service.getAllOpenComplaints(currentUser.getUserId());
	}

	@GetMapping("/get")
	public Engineer getEngineer(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");

		return service.getEngineer(currentUser.getUserId());
	}

	@GetMapping("/resolved")
	public List<Complaint> getResolvedComplaints(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
		return service.getResolvedComplaints(currentUser.getUserId());
	}

	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody LoginDetails loginDetails, HttpServletRequest request) {

		if (service.login(loginDetails.getUserId(), loginDetails.getPassword())) {

			HttpSession session = request.getSession(true);
			loginDetails.setEngineer(true);
			session.setAttribute("userDetails", loginDetails);
			return new ResponseEntity<String>("LOGGED IN", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/logout")
	public ResponseEntity<String> logOut(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND);
		}

		HttpSession session = request.getSession(true);
		LoginDetails loginDetails = (LoginDetails) session.getAttribute("userDetails");
		loginDetails.setEngineer(false);
		session.setAttribute("userDetails", loginDetails);
		return new ResponseEntity<String>("LOGGED OUT", HttpStatus.FOUND);
	}

}
