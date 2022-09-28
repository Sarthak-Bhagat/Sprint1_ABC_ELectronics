package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_admin")
public class Admin {
	@Id
	@SequenceGenerator(name = "admin_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "admin_sequence")
	private int adminid;
	private String password;
	private long contactNumber;
	private String emailId;
}
