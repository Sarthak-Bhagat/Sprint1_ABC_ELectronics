package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Complaint;
import com.capgemini.services.EngineerService;

@RestController
@RequestMapping("/engineer")
public class EngineerController {

	@Autowired
	EngineerService service;

	@GetMapping("/getAllOpenComplaints/{engineerId}")
	public List<Complaint> getAllOpenComplaints(@PathVariable long engineerId) {
		return service.getAllOpenComplaints(engineerId);
	}

	@GetMapping("/getResolvedComplaints/{engineerId}")
	public List<Complaint> getResolvedComplaints(@PathVariable long engineerId) {
		return service.getResolvedComplaints(engineerId);
	}

}
