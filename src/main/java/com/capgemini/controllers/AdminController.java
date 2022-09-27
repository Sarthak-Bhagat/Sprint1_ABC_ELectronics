package com.capgemini.controllers;


import java.util.List;

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
import com.capgemini.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("/engineer/add")
	public ResponseEntity<String> addEngineer(@RequestBody Engineer engineer) {
		service.addEngineer(engineer);
		return new ResponseEntity<String>("ADDED ENGINEER", HttpStatus.ACCEPTED);
	}

	@GetMapping("/complaint/all")
	public List<Complaint> getComplaints() {
		return service.getComplaints();
	}

	@GetMapping("/complaint/{modelNumber}")
	public List<Complaint> getComplaintsByProducts(@PathVariable long modelNumber) {
		return service.getComplaintsByProducts(modelNumber);
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

}
