package com.example.AuctionManagementSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AuctionManagementSystem.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByUser(Long userId);

}
