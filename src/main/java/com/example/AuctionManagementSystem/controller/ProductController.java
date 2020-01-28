package com.example.AuctionManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.service.ProductService;

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
		return productService.getProduct(userId);
	}
}
