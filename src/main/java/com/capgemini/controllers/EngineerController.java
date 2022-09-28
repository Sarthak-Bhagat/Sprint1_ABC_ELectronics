package com.capgemini.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginCreds;
import com.capgemini.services.EngineerService;

@RestController
@RequestMapping("/engineer")
public class EngineerController {

	@Autowired
	EngineerService service;

	@GetMapping("/all")
	public List<Engineer> getAllEngineers() {
		return service.getEngineers();
	}

	@GetMapping("/open/{engineerId}")
	public List<Complaint> getAllOpenComplaints(@PathVariable long engineerId) {
		return service.getAllOpenComplaints(engineerId);
	}

	@GetMapping("/resolved/{engineerId}")
	public List<Complaint> getResolvedComplaints(@PathVariable long engineerId) {
		return service.getResolvedComplaints(engineerId);
	}

	@PostMapping("/signin")
	public void signInWithCredentials(@RequestBody LoginCreds creds, HttpServletRequest request) {

		long username = creds.getUserId();
		String password = creds.getPassword();

		if (service.login(username, password)) {

			HttpSession session = request.getSession(true);

			session.setAttribute("engineer", true);
		} else {
			throw new InvalidCredentialsException();
		}

	}

}
