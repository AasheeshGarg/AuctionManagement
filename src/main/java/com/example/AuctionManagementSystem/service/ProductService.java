package com.example.AuctionManagementSystem.service;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	@Autowired
	private UserService userService;
	
//	public void addProduct(Product product) {
//		List<User> users = userService.getAllUsers();
//		for(User u : users) {
//			List<Product> products = this.getProductsByUserId(Long.toString(u.getUserId()));
//			if(products.isEmpty())
//				productRepository.save(product);
//			for(Product p : products) {
//				if(p.getProductName().equals(product.getProductName())) {
//					logger.info("Product already Added !!!");
//					throw new IllegalArgumentException("Product already present.");
//				}
//				else if(product.getProductName().isEmpty()){
//					logger.info("Please enter Product Name");
//					throw new IllegalArgumentException("Invalid product name.");
//				}
//
//
//					productRepository.save(product);
//			}
//		}
//	}


	public void addProduct(Product product) {

		if(null == product.getProductName() || product.getProductName().isEmpty()){
			logger.info("Please enter Product Name");
			throw new IllegalArgumentException("Invalid product name.");
		}

		User user = userService.getUser(product.getUser().getUsername());

if(user.getProducts() != null) {
	for (Product p : user.getProducts()) {
		if (p.getProductName().equals(product.getProductName())) {
			logger.info("Product already Added !!!");
			throw new IllegalArgumentException("Product already present.");
		}

	}
}
		productRepository.save(product);
	}

	public List<Product> getProductsByUserId(String userId) {
		User user = userService.getUserById(Long.valueOf(userId));
		return user.getProducts();
	}

	public Product getProductById(long productId) {
		return productRepository.findById(productId).get();

	}

	
}
