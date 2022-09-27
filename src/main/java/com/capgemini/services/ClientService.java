package com.capgemini.services;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;

public interface ClientService {

//	void changeStatusOfComplaint(int complaintId);

	void addClient(Client client);

	Client getClientByClientId(long clientId);

	Engineer getEngineerByComplaintId(long complaintId);

	Client signIn(Client client);

	Client signOut(Client client);
}
