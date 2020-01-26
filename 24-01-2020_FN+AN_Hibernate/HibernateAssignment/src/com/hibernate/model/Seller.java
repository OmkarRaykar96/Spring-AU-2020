package com.hibernate.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "seller")
public class Seller extends User {

	//Default Constructor
	public Seller() {

	}

	//Parameterized Constructor
	public Seller(String username, String mobile_no, String email, Address home_address, Address office_address) {
		super(username, mobile_no, email, home_address, office_address);

	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SELLER_ID")
	private Collection<Product> productList = new ArrayList();

	@Override
	public String toString() {
		return "Seller [productList=" + productList + "]";
	}

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}

}