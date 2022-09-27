package com.capgemini.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

	@Query(value = "Select * from Complaint where client_id = ?1", nativeQuery = true)
	List<Complaint> findByClientId(long clientid);

	@Query(value = "Select * from Complaint where employee_id = ?1", nativeQuery = true)
	List<Complaint> findByEmployeeId(long engineerId);

	@Query(value = "Select * from Complaint where product_model_number = ?1", nativeQuery = true)
	List<Complaint> findByModelNumber(long modelNumber);
}
