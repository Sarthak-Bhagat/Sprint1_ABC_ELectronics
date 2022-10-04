package com.capgemini.services;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;

public interface ClientService {

	void addClient(Client client);

	Product addProduct(long modelNumber, long clientId);

//	void changeStatusOfComplaint(int complaintId);

	Client getClientByClientId(long clientId);

	Engineer getEngineerByComplaintId(long complaintId);

	boolean login(long clientId, String password);
}
