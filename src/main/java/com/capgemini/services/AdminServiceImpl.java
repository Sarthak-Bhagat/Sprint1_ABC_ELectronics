package com.capgemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Admin;
import com.capgemini.entities.Client;
import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidComplaintIdException;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.InvalidEngineerIdException;
import com.capgemini.exceptions.InvalidModelNumberException;
import com.capgemini.repositories.AdminRepo;
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

	@Autowired
	AdminRepo adminRepo;

	@Override
	public void addAdmin(Admin admin) {
		adminRepo.save(admin);
	}

	@Override
	public void addEngineer(Engineer engineer) {
		engineerRepo.save(engineer);
	}

	@Override
	public List<Client> getClients() {
		return clientRepo.findAll();
	}

	@Override
	public List<Complaint> getComplaints() {
		return complaintRepo.findAll();
	}

	@Override
	public List<Complaint> getComplaintsByProducts(long modelNumber) {
		productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);
		return complaintRepo.findByProductModelNumber(modelNumber);
	}

	@Override
	public Engineer getEngineerById(long engineerId) {
		return engineerRepo.findById(engineerId).orElseThrow(InvalidEngineerIdException::new);
	}

	@Override
	public List<Engineer> getEngineers() {
		return engineerRepo.findAll();
	}

	@Override
	public boolean login(long adminId, String password) {
		Admin admin = adminRepo.findById(adminId).orElseThrow(InvalidCredentialsException::new);
		String pass = admin.getPassword();
		if (!pass.equals(password)) {
			throw new InvalidCredentialsException();
		}
		return true;
	}

	@Override
	public void removeEngineer(long employeeid) {
		Engineer engineer = engineerRepo.findById(employeeid).orElseThrow(InvalidEngineerIdException::new);
		engineerRepo.delete(engineer);
	}

	@Override
	public Complaint replaceEmployeeFromComplaint(long employeeId, long complainId) {
		Complaint complaint = complaintRepo.findById(complainId).orElseThrow(InvalidComplaintIdException::new);

		Engineer engineer = engineerRepo.findById(employeeId).orElseThrow(InvalidEngineerIdException::new);

		complaint.setEngineer(engineer);
		complaintRepo.save(complaint);
		return complaint;
	}

}
