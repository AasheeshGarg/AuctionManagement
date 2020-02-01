package com.example.AuctionManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.model.AuctionStatus;
import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.AuctionRepository;

@Service
public class AuctionService {
	
	@Autowired
	private AuctionRepository auctionRepository;

	@Autowired
	private UserService userService;
	
	public void saveAuction(Auction auction) {
		auctionRepository.save(auction);	
	}

	public List<Auction> getAllAuctions() {
		List<Auction> auctions = new ArrayList<>();
		auctionRepository.findAll().forEach(auctions::add);
		return auctions;
	}

	public User getResult(long auctionId) {
		Optional<Auction> auction = auctionRepository.findById(auctionId);
		long winnerUserId = auction.get().getWinnerUserId();
		User user = userService.getUserById(winnerUserId);
		return user;
	}
	
}
