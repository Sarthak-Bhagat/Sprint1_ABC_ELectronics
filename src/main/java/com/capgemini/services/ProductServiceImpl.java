package com.capgemini.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidModelNumberException;
import com.capgemini.repositories.ComplaintRepo;
import com.capgemini.repositories.EngineerRepo;
import com.capgemini.repositories.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	EngineerRepo engineerRepo;

	@Autowired
	ComplaintRepo complaintRepo;

	@Override
	public void addProduct(Product product) {
		product.setWarrantyDate(LocalDate.now().plusYears(product.getWarrantyYears()));
		productRepo.save(product);
	}

	@Override
	public List<Engineer> getEngineers(long modelNumber) {
		productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);

		List<Complaint> complaints = complaintRepo.findByProductModelNumber(modelNumber);
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
	public List<Complaint> getProductComplaints(long modelNumber) {
		productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);

		return complaintRepo.findByProductModelNumber(modelNumber);

	}

	@Override
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	@Override
	public void removeProduct(long modelNumber) {

		productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);
		productRepo.deleteById(modelNumber);
	}

	@Override
	public void updateProductWarranty(long warrantyYears, long modelNumber) {
		Product product = productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);
		long yearsToAdd = warrantyYears - product.getWarrantyYears();
		product.setWarrantyYears(warrantyYears);
		LocalDate warrantyDate = product.getDateofPurchase().plusYears(yearsToAdd);
		System.out.println(product.getDateofPurchase() + " " + warrantyDate);
		product.setWarrantyDate(warrantyDate);
		productRepo.save(product);
	}

}
