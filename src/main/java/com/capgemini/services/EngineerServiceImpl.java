package com.capgemini.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.repositories.ClientRepo;
import com.capgemini.repositories.ComplaintRepo;
import com.capgemini.repositories.EngineerRepo;
import com.capgemini.repositories.ProductRepo;

@Service
public class EngineerServiceImpl implements EngineerService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	EngineerRepo engineerRepo;

	@Autowired
	ComplaintRepo complaintRepo;

	@Autowired
	ClientRepo clientRepo;

	public void addEngineer(Engineer engineer) {
		engineerRepo.save(engineer);
	}

	@Override
	public List<Complaint> getAllOpenComplaints(long engineerId) {
		List<Complaint> complaints = complaintRepo.findByEngineerEmployeeId(engineerId);
		return complaints.stream().filter(c -> c.getStatus() == "open").collect(Collectors.toList());
	}

	@Override
	public List<Engineer> getEngineers() {
		return engineerRepo.findAll();
	}

	@Override
	public List<Complaint> getResolvedComplaints(long engineerId) {
		List<Complaint> complaints = complaintRepo.findByEngineerEmployeeId(engineerId);
		return complaints.stream().filter(c -> c.getStatus() == "resolved").collect(Collectors.toList());
	}

	@Override
	public boolean login(long userId, String password) {
		Engineer engineer = engineerRepo.findById(userId).orElseThrow(InvalidCredentialsException::new);
		String pass = engineer.getPassword();
		return pass == password;
	}


}
