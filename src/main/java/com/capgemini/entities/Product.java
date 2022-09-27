package com.capgemini.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity
@Table(name = "tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long modelNumber; // Changed from String to int
	private String productName;
	private String productCategoryName;
	private LocalDate dateotPurchase;
	private int warrentyYears;
	private LocalDate warrantyDate;
//	private String warrantyStatus;

	@OneToOne(mappedBy = "product")
	private Complaint complaint;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
//	private Client client;

}
