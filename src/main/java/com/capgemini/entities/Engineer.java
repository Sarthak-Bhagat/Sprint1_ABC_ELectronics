package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_engineer")
public class Engineer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String password;
	private String engineerName;
//	private String domain;

	@OneToOne(mappedBy = "engineer")
	private Complaint complaint;
//	@OneToMany(mappedBy = "engineer")
//	List<Complaint> complaint;
}
