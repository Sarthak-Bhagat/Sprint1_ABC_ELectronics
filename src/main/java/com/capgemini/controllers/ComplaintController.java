package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.services.ComplaintService;

@RestController
@RequestMapping("/complaint")

public class ComplaintController {
	@Autowired
	ComplaintService service;

	@GetMapping("/book/{clientId}/{modelNumber}/{complaintName}")
	public ResponseEntity<String> bookComplaint(@PathVariable long clientId, @PathVariable long modelNumber,
			@PathVariable String complaintName) {
		// TODO Switch to Post
		service.bookComplaint(clientId, modelNumber, complaintName);
		return new ResponseEntity<String>("Complaint Booked", HttpStatus.ACCEPTED);
	}

	@GetMapping("/changestatus/{complaintId}")
	public String changeComplaintStatus(@PathVariable long complaintId) {
		return service.changeComplaintStatus(complaintId);
	}

	@GetMapping("/client/{clinetId}/all")
	public List<Complaint> getClientAllComplaints(@PathVariable long clientId) {
		return service.getClientAllComplaints(clientId);
	}

	@GetMapping("/client/{clientId}/open")
	public List<Complaint> getClientAllOpenComplaints(@PathVariable long clientId) {
		return service.getClientAllOpenComplaints(clientId);

	}

	@GetMapping("/getengineer/{complaintId}")
	public Engineer getEngineer(@PathVariable long complaintId) {
		return service.getEngineer(complaintId);
	}

	@GetMapping("/getproduct/{complaintId}")
	public Product getProduct(@PathVariable long complaintId) {
		return service.getProduct(complaintId);
	}

}
