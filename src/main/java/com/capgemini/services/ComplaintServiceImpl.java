package com.capgemini.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.repositories.ClientRepo;
import com.capgemini.repositories.ComplaintRepo;
import com.capgemini.repositories.EngineerRepo;
import com.capgemini.repositories.ProductRepo;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	EngineerRepo engineerRepo;

	@Autowired
	ComplaintRepo complaintRepo;

	@Autowired
	ClientRepo clientRepo;

	@Override
	@Transactional
	public String bookComplaint(long clientId, long modelNumber, String complainName) {
		// TODO Load balance randomEngineer
		List<Engineer> engineers = engineerRepo.findAll();
		System.out.println(engineers);
		Random rand = new Random();
		Engineer randomEngineer = engineers.get(rand.nextInt(engineers.size()));

		Complaint complaint = new Complaint();
		complaint.setComplaintName(complainName);
		complaint.setClient(clientRepo.findById(clientId).get());
		complaint.setProduct(productRepo.findById(modelNumber).get());
		complaint.setEngineer(randomEngineer);
		complaint.setStatus("open");

		complaintRepo.save(complaint);
		return "Complaint Lodged";
	}

	@Override
	public String changeComplaintStatus(long complaintId) {
		Complaint complaint = complaintRepo.findById(complaintId).get();
		String status = complaint.getStatus();
//		status = status == "open" ? "resolved" : "open";
		if (status == "open") {
			status = "resolved";
		} else {
			status = "open";
		}
		complaint.setStatus(status);

		return "The complaint has been set to " + status;
	}

	@Override
	public List<Complaint> getClientAllComplaints(long clientid) {
		return complaintRepo.findByClientId(clientid);
	}

	@Override
	public List<Complaint> getClientAllOpenComplaints(long clientid) {
		List<Complaint> complaints = complaintRepo.findByClientId(clientid);
		return complaints.stream().filter(c -> c.getStatus() == "open").collect(Collectors.toList());
	}

	@Override
	public Engineer getEngineer(long complaintId) {
		return complaintRepo.findById(complaintId).get().getEngineer();
	}

	@Override
	public Product getProduct(long complaintId) {
		return complaintRepo.findById(complaintId).get().getProduct();
	}

}
