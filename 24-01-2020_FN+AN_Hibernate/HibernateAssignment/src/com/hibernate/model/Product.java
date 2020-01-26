package com.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue()
	private int productId;
	private String productNAme;
	private int price;

	@Lob
	private String description;

	@ManyToOne
	private Seller seller;

	public Product(String productNAme, int price, String description) {
		super();
		this.productNAme = productNAme;
		this.price = price;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product() {

	}

	public String getProductNAme() {
		return productNAme;
	}

	public void setProductNAme(String productNAme) {
		this.productNAme = productNAme;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [ productId=" + productId + ", productNAme=" + productNAme + ", price=" + price
				+ ", description=" + description + "]";
	}

}