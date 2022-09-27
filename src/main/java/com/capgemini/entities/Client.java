package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clientId;
	private String password;
	private String address;
	private long phoneNumber;

	@OneToOne(mappedBy = "client")
	private Complaint complaint;
//	@OneToMany(mappedBy = "client")
//	List<Complaint> complaint;

//	@OneToOne(mappedBy = "product")
//	private Product product;
}
