package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "tbl_engineer")
public class Engineer {
	@Id
	@SequenceGenerator(name = "engineer_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "course_sequence")
	private long employeeId;
	private String password;
	private String engineerName;

	@OneToMany(mappedBy = "engineer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Complaint> complaint = new ArrayList<>();

	public Engineer(String engName, String password) {
		this.engineerName = engName;
		this.password = password;
	}

}
