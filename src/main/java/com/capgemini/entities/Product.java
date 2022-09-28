package com.capgemini.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity
@Table(name = "tbl_product")
public class Product {
	@Id
	@SequenceGenerator(name = "product_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_sequence")
	private long modelNumber; // Changed from String to int
	private String productName;
	private String productCategoryName;
	private LocalDate dateofPurchase;
	private long warrentyYears;
	private LocalDate warrantyDate;
//	private String warrantyStatus;

	@OneToMany(mappedBy = "product")
	List<Complaint> complaint;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
//	private Client client;

}
