package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {

//	void changeStatusOfComplaint(int complaintId);

}
