package com.example.AuctionManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.repository.AuctionRepository;

@Service
public class AuctionService {
	
	@Autowired
	private AuctionRepository auctionRepository;

	public void saveAuction(Auction auction) {
		auctionRepository.save(auction);	
	}
}
