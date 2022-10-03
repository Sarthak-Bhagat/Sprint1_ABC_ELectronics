package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tbl_client")
public class Client {
	@Id
	@SequenceGenerator(name = "client_sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "client_sequence")
	private long clientId;
	private String password;
	private String address;
	private long phoneNumber;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Complaint> complaint = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Product> product = new ArrayList<Product>();

	public Client(String address, String password, long phoneNumber) {
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;

	}

	public void addProduct(Product product) {
		this.product.add(product);
	}
}
