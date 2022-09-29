package com.capgemini.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidClientIdException;
import com.capgemini.exceptions.InvalidComplaintIdException;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.InvalidModelNumberException;
import com.capgemini.exceptions.OutOfWarrantyException;
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
		Product product = productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);

		if (product.getWarrantyDate().compareTo(LocalDate.now()) <= 0) {
			throw new OutOfWarrantyException();
		}

		Complaint complaint = new Complaint();
		complaint.setComplaintName(complainName);
		complaint.setClient(clientRepo.findById(clientId).orElseThrow(InvalidClientIdException::new));
		complaint.setProduct(product);
		complaint.setEngineer(randomEngineer);
		complaint.setStatus("open");

		complaintRepo.save(complaint);
		return "Complaint Lodged";
	}

	@Override
	public String changeComplaintStatus(long complaintId) {
		Complaint complaint = complaintRepo.findById(complaintId).orElseThrow(InvalidComplaintIdException::new);
		String status = complaint.getStatus();
		//System.out.println(status);
		status = status.equals("open")? "resolved" : "open";
//		if (status == "open") {
//			status = "resolved";
//		} else {
//			status = "open";
//		}
		//System.out.println(status);
		complaint.setStatus(status);

		return "The complaint has been set to " + status;
	}

	@Override
	public List<Complaint> getClientAllComplaints(long clientid) {
		return complaintRepo.findByClientClientId(clientid);
	}

	@Override
	public List<Complaint> getClientAllOpenComplaints(long clientid) {
		List<Complaint> complaints = complaintRepo.findByClientClientId(clientid);
		return complaints.stream().filter(c -> c.getStatus() == "open").collect(Collectors.toList());
	}

	@Override
	public Engineer getEngineer(long complaintId) {
		return complaintRepo.findById(complaintId).orElseThrow(InvalidComplaintIdException::new).getEngineer();
	}

	@Override
	public Product getProduct(long complaintId) {
		return complaintRepo.findById(complaintId).orElseThrow(InvalidComplaintIdException::new).getProduct();
	}

	@Override
	public boolean login(long userId, String password) {
		
		Engineer engineer = engineerRepo.findById(userId).orElseThrow(InvalidCredentialsException::new);
		String pass = engineer.getPassword();
		return pass.equals(password);
	}

}
