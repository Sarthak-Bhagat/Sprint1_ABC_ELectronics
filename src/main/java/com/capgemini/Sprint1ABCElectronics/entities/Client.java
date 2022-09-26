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
@Table(name = "tbl_client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne
	private int clientId;
	private String password;
	private String address;
	private long phoneNumber;
}
