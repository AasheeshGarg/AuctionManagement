package com.example.AuctionManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}

		public List<Product> getProduct(String userId) {
			return productRepository.findByUserId(userId);
	}

	
}
