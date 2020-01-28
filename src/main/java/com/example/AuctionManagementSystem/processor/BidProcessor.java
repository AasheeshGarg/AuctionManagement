package com.example.AuctionManagementSystem.processor;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.model.AuctionStatus;
import com.example.AuctionManagementSystem.model.BidStatus;
import com.example.AuctionManagementSystem.model.UserBid;
import com.example.AuctionManagementSystem.repository.AuctionRepository;
import com.example.AuctionManagementSystem.repository.UserBidRepository;

@Service
public class BidProcessor {

	@Autowired
	private AuctionRepository aRepository;

	@Autowired
	private UserBidRepository userBidRepository;

	@Scheduled(fixedRate = 1000)
	public void process() {
		System.out.println("Processing...");
		List<Auction> findByStatus = aRepository.findByStatus(AuctionStatus.OPEN);
		System.out.println("Found..." + findByStatus);
		findByStatus.stream().filter(i -> i.getEndDate().before(new Date())).forEach(i -> {
			i.setStatus(AuctionStatus.CLOSED);
			aRepository.save(i);

			System.out.println("closing bid for..." + i);
			Optional<List<UserBid>> findByAuction = userBidRepository.findByAuction(i);
			System.out.println("Updating bid for..." + findByAuction);
			if (findByAuction.isPresent()) {
				List<UserBid> list = findByAuction.get();
				Collections.sort(list);
				UserBid userBid = list.get(0);

				userBid.setBidStatus(BidStatus.AWARDED);
				System.out.println("Awarding for..." + userBid);
				userBidRepository.save(userBid);
			}

		});
	}
}
