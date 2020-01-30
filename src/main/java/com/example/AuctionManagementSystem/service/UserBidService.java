package com.example.AuctionManagementSystem.service;

import com.example.AuctionManagementSystem.model.UserBid;
import com.example.AuctionManagementSystem.repository.UserBidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBidService {

	@Autowired
	private UserBidRepository bidRepository;

	public void saveBid(UserBid userBid) {
		bidRepository.save(userBid);	
	}

	public List<UserBid> getBids(String productId) {
		return bidRepository.findByAuctionProduct(Long.valueOf(productId));
	}
}
