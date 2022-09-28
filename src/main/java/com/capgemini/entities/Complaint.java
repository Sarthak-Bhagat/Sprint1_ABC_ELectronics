package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "tbl_complaint")
public class Complaint {
	@Id
	@SequenceGenerator(name = "complaint_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "complaint_sequence")
	private long complaintId;
	private String complaintName;
	private String status;
//	private LocalDate

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
	@ToString.Exclude
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	@ToString.Exclude
	private Engineer engineer;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_model_number", referencedColumnName = "modelNumber")
	@ToString.Exclude
	private Product product;
}
