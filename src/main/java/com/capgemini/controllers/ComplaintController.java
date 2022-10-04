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
import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginDetails;
import com.capgemini.services.ComplaintService;

@RestController
@RequestMapping("/complaint")

public class ComplaintController {
	@Autowired
	ComplaintService service;

	@GetMapping("/book/{modelNumber}/{complaintName}")
	public ResponseEntity<String> bookComplaint(@PathVariable long modelNumber, @PathVariable String complaintName,
			HttpServletRequest request) {
		// TODO Switch to Post
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
		service.bookComplaint(currentUser.getUserId(), modelNumber, complaintName);
		return new ResponseEntity<String>("Complaint Booked", HttpStatus.ACCEPTED);
	}

	@GetMapping("/changestatus/{complaintId}")
	public String changeComplaintStatus(@PathVariable long complaintId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.changeComplaintStatus(complaintId);
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

	@GetMapping("/get/all")
	public List<Complaint> getClientAllComplaints(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
		return service.getClientAllComplaints(currentUser.getUserId());
	}

	@GetMapping("/get/open")
	public List<Complaint> getClientAllOpenComplaints(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		HttpSession session = request.getSession();
		LoginDetails currentUser = (LoginDetails) session.getAttribute("userDetails");
		return service.getClientAllOpenComplaints(currentUser.getUserId());

	}

	@GetMapping("/getengineer/{complaintId}")
	public Engineer getEngineer(@PathVariable long complaintId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getEngineer(complaintId);
	}

	@GetMapping("/getproduct/{complaintId}")
	public Product getProduct(@PathVariable long complaintId, HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			throw new InvalidCredentialsException();
		}
		return service.getProduct(complaintId);
	}

	@PostMapping("/login")
	public ResponseEntity<String> signInWithCredentials(@RequestBody LoginDetails loginDetails,
			HttpServletRequest request) {

		if (service.login(loginDetails.getUserId(), loginDetails.getPassword())) {

			HttpSession session = request.getSession(true);
			loginDetails.setClient(true);
			session.setAttribute("userDetails", loginDetails);
			return new ResponseEntity<String>("LOGGED IN", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> signout(HttpServletRequest request) {
		boolean validLogin = checkSession(request);

		if (!validLogin) {
			return new ResponseEntity<String>("USER NOT FOUND", HttpStatus.NOT_FOUND);
		}

		HttpSession session = request.getSession(true);
		LoginDetails loginDetails = (LoginDetails) session.getAttribute("userDetails");
		loginDetails.setClient(false);
		session.setAttribute("userDetails", loginDetails);
		return new ResponseEntity<String>("LOGGED IN", HttpStatus.FOUND);
	}

}
