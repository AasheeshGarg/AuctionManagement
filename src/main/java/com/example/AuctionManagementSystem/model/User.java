package com.example.AuctionManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long userId;
	private String username;
	@Size(min=6, max=20, message="Password length should be minimum 6")
	private String password;
	private UserType userType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Product> products;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", products=" + products + "]";
	}

	public User(long userId, String username, String password, UserType userType, List<Product> products) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.products = products;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;

	}

	public User(long userId) {
		super();
		this.userId = userId;
	}

	public User() {
		super();
	}

}
