package com.capgemini.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
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
		List<Complaint> complaints = complaintRepo.findByEmployeeId(engineerId);
		return complaints.stream().filter(c -> c.getStatus() == "open").collect(Collectors.toList());
	}

	@Override
	public List<Complaint> getResolvedComplaints(long engineerId) {
		List<Complaint> complaints = complaintRepo.findByEmployeeId(engineerId);
		return complaints.stream().filter(c -> c.getStatus() == "resolved").collect(Collectors.toList());
	}

//	@Override
//	public List<Complaint> getResolvedComplaintsByDate(long engineerId, String date) {
//		LocalDate.parse(date);
//		List<Complaint> complaints = complaintRepo.findByEmployeeId(engineerId);
//		return complaints.stream().filter(c -> c.getStatus() == "resolved").filter(c -> c.getDate() > complaints)).collect(Collectors.toList());
//	}

}
