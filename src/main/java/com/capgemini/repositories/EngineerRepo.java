package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Engineer;

public interface EngineerRepo extends JpaRepository<Engineer, Long> {

}
