package com.example.AuctionManagementSystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Auction {
	@Id
	@GeneratedValue
	private long auctionId;
	private float minPrice;
	private float minIncrement;
	private Date startDate;
	private Date endDate;
	private AuctionStatus status;
	private String winnerUserId;
	@OneToOne()
	@JoinColumn(name = "productId")
	private Product product;
	@OneToOne()
	@JoinColumn(name = "userId")
	private User user;

	public Auction(long auctionId, float minPrice, float minIncrement, Date startDate, Date endDate,
			AuctionStatus status, String winnerUserId, Product product, User user) {
		super();
		this.auctionId = auctionId;
		this.minPrice = minPrice;
		this.minIncrement = minIncrement;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.winnerUserId = winnerUserId;
		this.product = product;
		this.user = user;
	}

	public Auction() {
		super();
	}

	public long getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(long auctionId) {
		this.auctionId = auctionId;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMinIncrement() {
		return minIncrement;
	}

	public void setMinIncrement(float minIncrement) {
		this.minIncrement = minIncrement;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public AuctionStatus getStatus() {
		return status;
	}

	public void setStatus(AuctionStatus status) {
		this.status = status;
	}

	public String getWinnerUserId() {
		return winnerUserId;
	}

	public void setWinnerUserId(String winnerUserId) {
		this.winnerUserId = winnerUserId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", minPrice=" + minPrice + ", minIncrement=" + minIncrement
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", winnerUserId="
				+ winnerUserId + ", product=" + product + ", user=" + user + "]";
	}

}
