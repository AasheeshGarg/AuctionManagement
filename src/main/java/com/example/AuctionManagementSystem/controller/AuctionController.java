package com.example.AuctionManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.model.AuctionStatus;
import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.service.AuctionService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class AuctionController {
	
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping(value = "/auction", method = RequestMethod.POST)
    public void saveAuction(@RequestBody Auction auction){
		auctionService.saveAuction(auction);
    }
	
	@RequestMapping(value = "/auctions", method = RequestMethod.GET)
	public List<Auction> getAuctions() {
		return auctionService.getAllAuctions();
	}
	
	@RequestMapping(value = "/result/{auctionId}", method = RequestMethod.GET)
	public User getResult(@PathVariable long auctionId) {
		return auctionService.getResult(auctionId);
	}
	
}
