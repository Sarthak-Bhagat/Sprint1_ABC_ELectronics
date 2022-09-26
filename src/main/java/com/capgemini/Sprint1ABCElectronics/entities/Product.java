package com.capgemini.Sprint1ABCElectronics.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int modelNumber; // Changed from String to int
	private String productName;
	private String productCategoryName;
	private LocalDate dateotPurchase;
	private int warrentyYears;
	private LocalDate warrantyDate;

	@OneToOne(mappedBy = "product")
	private Complaint complaint;
}
