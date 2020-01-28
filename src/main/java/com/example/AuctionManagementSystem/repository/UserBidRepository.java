package com.example.AuctionManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AuctionManagementSystem.model.Auction;
import com.example.AuctionManagementSystem.model.UserBid;

@Repository
public interface UserBidRepository extends CrudRepository<UserBid, Long> {

	List<UserBid> findByAuctionProduct(Long productId);

	Optional<List<UserBid>> findByAuction(Auction i);

}
