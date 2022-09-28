package com.capgemini.services;

import java.util.List;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;

public interface EngineerService {

	List<Complaint> getAllOpenComplaints(long engineerId);

	List<Engineer> getEngineers();

	List<Complaint> getResolvedComplaints(long engineerId);

//	List<Complaint> getResolvedComplaintsByDate(long engineerId, String date);

	boolean login(long userId, String password);

}
