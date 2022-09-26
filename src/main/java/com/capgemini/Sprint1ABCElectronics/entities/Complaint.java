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
@Table(name = "tbl_complaint")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complaintId;
	private String complaintName;
	private String status;
	@OneToOne
	private String productModelNumber;
	@OneToOne
	private int engineerld;
	@OneToOne
	private String clientld;
}
