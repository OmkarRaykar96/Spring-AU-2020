package com.hibernate.model;

import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "orders")
@NamedQueries({ @NamedQuery(name = "GET_ALL_ORDERS", query = "from Order") })
public class Order {

	// Default Constructor
	public Order() {

	}

	@Id
	@GeneratedValue()
	private int orderId;

	@ManyToOne
	private Buyer buyer;

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	@ElementCollection
	private Collection<Product> productList = new ArrayList();

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", buyer=" + buyer + ", productList=" + productList + "]";
	}

}