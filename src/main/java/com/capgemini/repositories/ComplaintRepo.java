package com.capgemini.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.entities.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

//	@Query(value = "Select * from tbl_complaint where client_id = ?1", nativeQuery = true)
	@Query("Select all c from Complaint c where c.client.clientId = ?1")
	List<Complaint> findByClientId(long clientid);

//	@Query(value = "Select * from Complaint where employee_id = ?1", nativeQuery = true)
	@Query("Select all c from Complaint c where c.engineer.employee_id = ?1")
	List<Complaint> findByEmployeeId(long engineerId);

//	@Query(value = "Select * from Complaint where product_model_number = ?1", nativeQuery = true)
	@Query("Select all c from Complaint c where c.product.modelNumber = ?1")
	List<Complaint> findByModelNumber(long modelNumber);
}
