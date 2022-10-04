package com.capgemini.services;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Client;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;
import com.capgemini.exceptions.InvalidClientIdException;
import com.capgemini.exceptions.InvalidComplaintIdException;
import com.capgemini.exceptions.InvalidCredentialsException;
import com.capgemini.exceptions.InvalidModelNumberException;
import com.capgemini.exceptions.ProductUnvailableException;
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
	@Transactional
	public Product addProduct(long modelNumber, long clientId) {
		Client client = clientRepo.findById(clientId).orElseThrow(InvalidClientIdException::new);
		Product product = productRepo.findById(modelNumber).orElseThrow(InvalidModelNumberException::new);
		if (product.isOwned()) {
			throw new ProductUnvailableException();
		}
		LocalDate purchaseDate = LocalDate.now();
		product.setDateofPurchase(LocalDate.now());
		product.setOwned(true);
		product.setWarrantyDate(purchaseDate.plusYears(product.getWarrantyYears()));
		client.addProduct(product);

		clientRepo.save(client);
		return product;
	}

	@Override
	public Client getClientByClientId(long clientId) {
		return clientRepo.findById(clientId).orElseThrow(InvalidClientIdException::new);
	}

	@Override
	public Engineer getEngineerByComplaintId(long complaintId) {
		return complaintRepo.findById(complaintId).orElseThrow(InvalidComplaintIdException::new).getEngineer();
	}

	@Override
	public boolean login(long clientId, String password) {
		Client client = clientRepo.findById(clientId).orElseThrow(InvalidCredentialsException::new);
		String pass = client.getPassword();
		if (!pass.equals(password)) {
			throw new InvalidCredentialsException();
		}
		return true;
	}
}
