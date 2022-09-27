package com.capgemini.services;

import java.util.List;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;

public interface ComplaintService {

	String bookComplaint(long clientId, long modelNumber, String complainName);

	String changeComplaintStatus(long complaintId);

	List<Complaint> getClientAllComplaints(long clientid);

	List<Complaint> getClientAllOpenComplaints(long clientid);

	Engineer getEngineer(long complaintId);

	Product getProduct(long complaintId);
}
