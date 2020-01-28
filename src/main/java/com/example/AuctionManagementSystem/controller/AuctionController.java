package com.example.AuctionManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.service.AuctionService;

@RestController
public class AuctionController {
	
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping(value = "/auction", method = RequestMethod.POST)
    public void saveAuction(@RequestBody Auction auction){
		auctionService.saveAuction(auction);
    }
}
