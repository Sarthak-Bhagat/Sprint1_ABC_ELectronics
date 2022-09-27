package com.capgemini.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;

@Repository
public interface AdminService {

	void addEngineer(Engineer engineer);

	List<Complaint> getComplaints();

	List<Complaint> getComplaintsByProducts(long modelNumber);

	void removeEngineer(long employeeid);

	Complaint replaceEmployeeFromComplaint(long employeeId, long complainId);
}
