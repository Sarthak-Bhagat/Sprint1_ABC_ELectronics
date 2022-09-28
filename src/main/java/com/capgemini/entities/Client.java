package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "tbl_client")
public class Client {
	@Id
	@SequenceGenerator(name = "client_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "client_sequence")
	private long clientId;
	private String password;
	private String address;
	private long phoneNumber;

	@OneToMany(mappedBy = "client")
	List<Complaint> complaint = new ArrayList<>();

	@OneToMany()
	@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Product> product = new ArrayList<Product>();

	public void addProduct(Product product) {
		this.product.add(product);
	}
}
