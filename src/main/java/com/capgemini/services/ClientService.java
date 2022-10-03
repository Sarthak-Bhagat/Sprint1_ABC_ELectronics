package com.capgemini.services;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;

public interface ClientService {

	void addClient(Client client);

	void addProduct(long modelNumber, long clientId);

//	void changeStatusOfComplaint(int complaintId);

	Client getClientByClientId(long clientId);

	Engineer getEngineerByComplaintId(long complaintId);

	boolean login(long clientId, String password);
}
