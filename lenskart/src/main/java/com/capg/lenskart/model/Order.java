package com.capg.lenskart.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Table")
public class Order {
	@Id
	private long orderId;
	private Date orderDate;
	private String orderStatus;
	private Double orderAmount;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Glass> glassList;
//	@OneToOne   ///order is already mapped to user so no need
//	@JoinColumn(name="fk_userId")
//	private User user;
	
	
	
	@OneToOne
	@JoinColumn(name="fk_transactionId")
	private Payment payment;
	
//	@OneToOne
//	@JoinColumn(name="fk_cartId")
//	private Cart cart;
	
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
//	public Cart getCart() {
//		return cart;
//	}
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public List<Glass> getGlassList() {
		return glassList;
	}
	public void setGlassList(List<Glass> glassList) {
		this.glassList = glassList;
	}
	

}
