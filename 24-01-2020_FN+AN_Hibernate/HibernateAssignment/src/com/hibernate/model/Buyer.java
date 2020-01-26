package com.hibernate.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer extends User {
	
	// Default Constructor
	public Buyer() {

	}

	// Parameterized Constructor
	public Buyer(String username, String mobile_no, String email, Address home_address, Address office_address) {
		super(username, mobile_no, email, home_address, office_address);

	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BUYER_ID")
	private Collection<Order> orderList = new ArrayList();

	public Collection<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}

}