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
		List<User> users = userService.getAllUsers();
		for(User u : users) {
			List<Product> products = this.getProduct(Long.toString(u.getUserId()));
			if(products.isEmpty())
				productRepository.save(product);
			for(Product p : products) {
				if(p.getProductName().equals(product.getProductName()))
					System.out.println("Product already Added !!!");
				else if(product.getProductName().isEmpty())
					System.out.println("Please enter Product Name");
				else
					productRepository.save(product);
			}
		}
	}

	public List<Product> getProduct(String userId) {
		User user = userRepository.findByUserId(new Long(userId));
		return user.getProducts();
	}

	
}
