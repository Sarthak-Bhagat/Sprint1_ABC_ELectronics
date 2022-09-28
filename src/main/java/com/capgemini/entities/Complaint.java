package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
	@ToString.Exclude
	@JsonIgnore
	private Client client;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	@ToString.Exclude
	@JsonIgnore
	private Engineer engineer;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_model_number", referencedColumnName = "modelNumber")
	@ToString.Exclude
	@JsonIgnore
	private Product product;
}
