package com.example.AuctionManagementSystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserBid implements Comparable<UserBid> {
	
	@Id
	@GeneratedValue
	private long bidId;
	private double bidValue;
	private BidStatus bidStatus;
	private Date date;
	@OneToOne()
	@JoinColumn(name = "auctionId")
	private Auction auction;
	@OneToOne()
	@JoinColumn(name = "userId")
	private User user;

	public long getBidId() {
		return bidId;
	}

	public void setBidId(long bidId) {
		this.bidId = bidId;
	}

	public Double getBidValue() {
		return bidValue;
	}

	public void setBidValue(Double bidValue) {
		this.bidValue = bidValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBid(long bidId, double bidValue, Date date, Auction auction, User user, BidStatus bidStatus) {
		super();
		this.bidId = bidId;
		this.bidValue = bidValue;
		this.date = date;
		this.auction = auction;
		this.user = user;
		this.bidStatus = bidStatus;
	}

	
	public UserBid() {
		super();
	}

	public BidStatus getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}

	@Override
	public String toString() {
		return "UserBid [bidId=" + bidId + ", bidValue=" + bidValue + ", bidStatus=" + bidStatus + ", date=" + date
				+ ", auction=" + auction + ", user=" + user + "]";
	}

	@Override
	public int compareTo(UserBid o) {
		return o.getBidValue().compareTo(this.getBidValue());
	}

}
