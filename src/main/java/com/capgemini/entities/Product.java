package com.capgemini.entities;

import java.time.LocalDate;
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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tbl_product")
public class Product {
	@Id
	@SequenceGenerator(name = "product_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_sequence")
	private long modelNumber;
	private String productName;
	private String productCategoryName;
	private LocalDate dateofPurchase;
	private long warrantyYears;
	private LocalDate warrantyDate;
	private boolean owned;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Complaint> complaint = new ArrayList<>();

	public Product(String productCategoryName, String productName, long warrantyYears) {
		this.productCategoryName = productCategoryName;
		this.productName = productName;
		this.warrantyYears = warrantyYears;
	}

}
