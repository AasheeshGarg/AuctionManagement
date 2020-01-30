package com.example.AuctionManagementSystem.processor;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.model.AuctionStatus;
import com.example.AuctionManagementSystem.model.BidStatus;
import com.example.AuctionManagementSystem.model.UserBid;
import com.example.AuctionManagementSystem.repository.AuctionRepository;
import com.example.AuctionManagementSystem.repository.UserBidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BidProcessor {

	@Autowired
	private AuctionRepository aRepository;

	@Autowired
	private UserBidRepository userBidRepository;

	private Logger logger = Logger.getLogger(BidProcessor.class.getName());

	@Scheduled(fixedRate = 1000)
	public void process() {
		System.out.println("Processing...");
		List<Auction> findByStatus = aRepository.findByStatus(AuctionStatus.OPEN);
		logger.info("Found..." + findByStatus);
		findByStatus.stream().filter(i -> i.getEndDate().before(new Date())).forEach(i -> {
			i.setStatus(AuctionStatus.CLOSED);
			aRepository.save(i);

			logger.info("closing bid for..." + i);
			Optional<List<UserBid>> findByAuction = userBidRepository.findByAuction(i);
			logger.info("Updating bid for..." + findByAuction);
			if (findByAuction.isPresent()) {
				List<UserBid> list = findByAuction.get();
				Collections.sort(list);
				UserBid userBid = list.get(0);

				userBid.setBidStatus(BidStatus.AWARDED);
				logger.info("Awarding for..." + userBid);
				userBidRepository.save(userBid);
			}

		});
	}
}
