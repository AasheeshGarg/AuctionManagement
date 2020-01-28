package com.example.AuctionManagementSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.model.AuctionStatus;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Long> {

	List<Auction> findByStatus(AuctionStatus open);

}
