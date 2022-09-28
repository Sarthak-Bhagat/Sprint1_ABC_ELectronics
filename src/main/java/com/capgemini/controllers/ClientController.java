package com.capgemini.controllers;

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
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.extra.LoginCreds;
import com.capgemini.services.ClientServiceImpl;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientServiceImpl cService;

	@PostMapping("/add")
	public ResponseEntity<String> addClient(@RequestBody Client client) {
		cService.addClient(client);
		return new ResponseEntity<String>("ADDED CLIENT", HttpStatus.ACCEPTED);
	}

	@GetMapping("/get/{clientId}")
	public Client getClientByClientId(@PathVariable long clientId) {
		return cService.getClientByClientId(clientId);
	}

	@GetMapping("/getengineer/{complaintid}")
	public Engineer getEngineerByComplaintId(@PathVariable long complaintId) {
		return cService.getEngineerByComplaintId(complaintId);
	}

	@PostMapping("/signin")
	public void signInWithCredentials(@RequestBody LoginCreds creds, HttpServletRequest request) {

		long username = creds.getUserId();
		String password = creds.getPassword();

		if (cService.login(username, password)) {

			HttpSession session = request.getSession(true);

			session.setAttribute("engineer", true);
		} else {
			throw new InvalidCredentialsException();
		}

	}

}
