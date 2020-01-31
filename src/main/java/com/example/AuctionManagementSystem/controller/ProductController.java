package com.example.AuctionManagementSystem.controller;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

	@RequestMapping(value = "/product/{userId}", method = RequestMethod.GET)
	public List<Product> getProducts(@PathVariable("userId") String userId) {
		return productService.getProductsByUserId(userId);
	}
}
