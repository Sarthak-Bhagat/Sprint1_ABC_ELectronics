package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_admin")
public class Admin {
	@Id
	@SequenceGenerator(name = "admin_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "admin_sequence")
	private long adminid;
	private String password;
	private long contactNumber;
	private String emailId;

	public Admin(String password, long contactNumber, String emailId) {
		this.password = password;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}
}
