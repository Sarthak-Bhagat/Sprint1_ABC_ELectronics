package com.capgemini.services;

import java.util.List;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;

public interface EngineerService {

	List<Complaint> getAllOpenComplaints(long engineerId);

	Engineer getEngineer(long engineerId);

//	List<Complaint> getResolvedComplaintsByDate(long engineerId, String date);

	List<Complaint> getResolvedComplaints(long engineerId);

	boolean login(long userId, String password);

}
