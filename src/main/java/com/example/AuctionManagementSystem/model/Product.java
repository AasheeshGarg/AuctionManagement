package com.example.AuctionManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private long productId;
	private String productName;
	private String description;

	@OneToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public Product(long productId, String productName, String description, User user) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.user = user;
	}

	
	public Product() {
		super();
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", user=" + user.getUsername() + "]";
	}

}
