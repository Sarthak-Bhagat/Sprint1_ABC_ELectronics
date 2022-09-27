package com.capgemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.repositories.ClientRepo;
import com.capgemini.repositories.ComplaintRepo;
import com.capgemini.repositories.EngineerRepo;
import com.capgemini.repositories.ProductRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	EngineerRepo engineerRepo;

	@Autowired
	ComplaintRepo complaintRepo;

	@Autowired
	ClientRepo clientRepo;

	@Override
	public void addEngineer(Engineer engineer) {
		engineerRepo.save(engineer);
	}

	@Override
	public List<Complaint> getComplaints() {
		return complaintRepo.findAll();
	}

	@Override
	public List<Complaint> getComplaintsByProducts(long modelNumber) {
		productRepo.findById(modelNumber);
		return complaintRepo.findByModelNumber(modelNumber);
	}

	@Override
	public void removeEngineer(long employeeid) {
		engineerRepo.delete(engineerRepo.findById(employeeid).get());
	}

	@Override
	public Complaint replaceEmployeeFromComplaint(long employeeId, long complainId) {
		complaintRepo.findById(complainId).get().setEngineer(engineerRepo.findById(employeeId).get());
		return complaintRepo.findById(complainId).get();
	}

}
