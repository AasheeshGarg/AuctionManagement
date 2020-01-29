package com.example.AuctionManagementSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.model.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByUser(User user);

}
