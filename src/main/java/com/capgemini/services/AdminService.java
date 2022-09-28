package com.capgemini.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.entities.Client;
import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;

@Repository
public interface AdminService {

	void addEngineer(Engineer engineer);

	List<Client> getClients();

	List<Complaint> getComplaints();

	List<Complaint> getComplaintsByProducts(long modelNumber);

	List<Engineer> getEngineers();

	boolean login(long adminId, String password);

	void removeEngineer(long employeeid);

	Complaint replaceEmployeeFromComplaint(long employeeId, long complainId);
}
