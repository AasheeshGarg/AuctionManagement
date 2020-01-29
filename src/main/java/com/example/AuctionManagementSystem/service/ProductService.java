package com.example.AuctionManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.repository.ProductRepository;
import com.example.AuctionManagementSystem.repository.UserRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getProduct(String userId) {
		User user = userRepository.findByUsername(userId);
		return productRepository.findByUserId(user);
	}

	
}
