package com.capgemini.services;

import java.util.List;

import com.capgemini.entities.Complaint;
import com.capgemini.entities.Engineer;
import com.capgemini.entities.Product;

public interface ProductService {
	void addProduct(Product product);

	List<Engineer> getEngineers(int modelNumber);

	List<Complaint> getProductComplaints(int modelNumber);

	List<Product> getProducts(); // Why string param?

	void removeProduct(long modelNumber);

	void updateProductWarranty(String warranty, long modelNumber);
}
