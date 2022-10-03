package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/get/assignedengineers/{modelNumber}")
	public List<Engineer> getEngineers(@PathVariable long modelNumber) {
		return service.getEngineers(modelNumber);
	}

	@GetMapping("/get/complaint/{modelNumber}")
	public List<Complaint> getProductComplaints(@PathVariable long modelNumber) {
		return service.getProductComplaints(modelNumber);
	}

	@GetMapping("/get/all")
	public List<Product> getProducts() {
		return service.getProducts();
	}
}
