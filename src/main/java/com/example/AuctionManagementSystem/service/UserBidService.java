package com.example.AuctionManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.UserBid;
import com.example.AuctionManagementSystem.repository.UserBidRepository;

@Service
public class UserBidService {

	@Autowired
	private UserBidRepository bidRepository;

	public void saveBid(UserBid userBid) {
		bidRepository.save(userBid);	
	}

	public List<UserBid> getBids(String productId) {
		return bidRepository.findByProductId(productId);
	}
}
