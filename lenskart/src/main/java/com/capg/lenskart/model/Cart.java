package com.capg.lenskart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	private int cartId;

//double doesnt works
	private Double cartAmount;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Glass> glassList;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

//public List<Order> getOrder() {
//	return order;
//}
//public void setOrder(List<Order> order) {
//	this.order = order;
//}
	public List<Glass> getGlassList() {
		return glassList;
	}

	public void setGlassList(List<Glass> glassList) {
		this.glassList = glassList;
	}

	public Double getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Double cartAmount) {
		this.cartAmount = cartAmount;
	}

}
