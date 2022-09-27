package com.capgemini.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

	List<Complaint> findByClientId(long clientid);

	List<Complaint> findByEmployeeId(long engineerId);

	List<Complaint> findByModelNumber(long modelNumber);

	List<Complaint> findComplaintsByModelNumber(int modelNumber);
}
