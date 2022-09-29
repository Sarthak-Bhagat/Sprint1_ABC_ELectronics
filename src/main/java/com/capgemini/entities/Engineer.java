package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_engineer")
public class Engineer {
	@Id
	@SequenceGenerator(name = "engineer_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "course_sequence")
	private long employeeId;
	private String password;
	private String engineerName;
	public Engineer(String engName, String password) {
		this.engineerName= engName;
		this.password=password;
	}

	@OneToMany(mappedBy = "engineer")
	List<Complaint> complaint = new ArrayList<>();
}
