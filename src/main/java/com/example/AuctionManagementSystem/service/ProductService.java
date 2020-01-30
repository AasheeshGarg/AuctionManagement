package com.example.AuctionManagementSystem.service;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserService userService;
	
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
		User user = userService.getUserById(Long.valueOf(userId));
		return user.getProducts();
	}

	
}
