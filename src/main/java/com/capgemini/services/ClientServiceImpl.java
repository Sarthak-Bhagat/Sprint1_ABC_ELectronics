package com.capgemini.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;
import com.capgemini.repositories.ClientRepo;
import com.capgemini.repositories.ComplaintRepo;
import com.capgemini.repositories.EngineerRepo;
import com.capgemini.repositories.ProductRepo;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	EngineerRepo engineerRepo;

	@Autowired
	ComplaintRepo complaintRepo;

	@Autowired
	ClientRepo clientRepo;

	@Override
	public void addClient(Client client) {
		clientRepo.save(client);
	}

	@Override
	public Client getClientByClientId(long clientId) {
		return clientRepo.findById(clientId).get();
	}

	@Override
	public Engineer getEngineerByComplaintId(long complaintId) {
		return complaintRepo.findById(complaintId).get().getEngineer();
	}

	@Override
	public Client signIn(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client signOut(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}
