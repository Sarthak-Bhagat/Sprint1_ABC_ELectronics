package com.capgemini.Sprint1ABCElectronics.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_engineer")
public class Engineer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne
	private int employeeId;
	private String password;
	private String engineerName;
	private String domain;
}
