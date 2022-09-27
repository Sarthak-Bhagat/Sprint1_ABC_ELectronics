package com.capgemini.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.repositories.ComplaintRepo;
import com.capgemini.repositories.EngineerRepo;
import com.capgemini.repositories.ProductRepo;

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	EngineerRepo engineerRepo;

	@Autowired
	ComplaintRepo complaintRepo;

	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public List<Engineer> getEngineers(int modelNumber) {
		// Get complaint from modelNumber, then get the engineerid from those complaints
		List<Complaint> complaints = complaintRepo.findComplaintsByModelNumber(modelNumber);
		List<Engineer> engineers = new ArrayList<Engineer>();

//		Iterator<Complaint> complaintIterator = complaints.iterator();
//		while (complaintIterator.hasNext()) {
//			engineers.add(complaintIterator.next().getEngineer());
//
//		}
		complaints.forEach(complaint -> engineers.add(complaint.getEngineer()));
		return engineers;
	}

	@Override
	public List<Complaint> getProductComplaints(int modelNumber) {
		return complaintRepo.findComplaintsByModelNumber(modelNumber);

	}

	@Override
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	@Override
	public void removeProduct(long modelNumber) {
		productRepo.deleteById(modelNumber);
	}

	@Override
	public void updateProductWarranty(String warranty, long modelNumber) {
		// Which product?
		LocalDate warrantDate = LocalDate.parse(warranty);
		Product product = productRepo.findById(modelNumber).get();
		product.setWarrantyDate(warrantDate);
		productRepo.save(product);
	}

}
