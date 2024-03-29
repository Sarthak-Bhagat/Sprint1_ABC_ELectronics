package com.capgemini.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.InvalidEngineerIdException;
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
		engineerRepo.findById(engineerId).orElseThrow(InvalidEngineerIdException::new);
		List<Complaint> complaints = complaintRepo.findByEngineerEmployeeId(engineerId);
		return complaints.stream().filter(c -> "open".equals(c.getStatus())).collect(Collectors.toList());
	}

	@Override
	public Engineer getEngineer(long engineerId) {
		return engineerRepo.findById(engineerId).orElseThrow(InvalidEngineerIdException::new);
	}

	@Override
	public List<Complaint> getResolvedComplaints(long engineerId) {
		engineerRepo.findById(engineerId).orElseThrow(InvalidEngineerIdException::new);
		List<Complaint> complaints = complaintRepo.findByEngineerEmployeeId(engineerId);
		return complaints.stream().filter(c -> "resolved".equals(c.getStatus())).collect(Collectors.toList());
	}

	@Override
	public boolean login(long clientId, String password) {
		Engineer engineer = engineerRepo.findById(clientId).orElseThrow(InvalidCredentialsException::new);
		String pass = engineer.getPassword();
		if (!pass.equals(password)) {
			throw new InvalidCredentialsException();
		}
		return true;
	}

}
