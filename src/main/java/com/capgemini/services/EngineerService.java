package com.capgemini.services;

import java.util.List;

import com.capgemini.entities.Complaint;

public interface EngineerService {

	List<Complaint> getAllOpenComplaints(long engineerId);

	List<Complaint> getResolvedComplaints(long engineerId);

//	List<Complaint> getResolvedComplaintsByDate(long engineerId, String date);

}
