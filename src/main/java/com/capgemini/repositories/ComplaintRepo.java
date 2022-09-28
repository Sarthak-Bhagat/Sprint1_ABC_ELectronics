package com.capgemini.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

	List<Complaint> findByClientClientId(long clientid);

	List<Complaint> findByEngineerEmployeeId(long engineerId);

	List<Complaint> findByProductModelNumber(long modelNumber);
}
