package com.example.AuctionManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuctionManagementSystem.model.BidStatus;
import com.example.AuctionManagementSystem.model.UserBid;
import com.example.AuctionManagementSystem.service.UserBidService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class UserBidController {

	@Autowired
	private UserBidService userBidService;

	@RequestMapping(value = "/bid", method = RequestMethod.POST)
	public void saveBid(@RequestBody UserBid userBid) {
		userBid.setBidStatus(BidStatus.CREATED);
		userBidService.saveBid(userBid);
	}

	@RequestMapping(value = "/bid/{productId}", method = RequestMethod.GET)
	public List<UserBid> getBids(@PathVariable("productId") String productId) {
		return userBidService.getBids(productId);
	}
}
