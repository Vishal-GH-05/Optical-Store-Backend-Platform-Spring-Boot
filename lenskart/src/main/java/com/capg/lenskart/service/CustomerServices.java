package com.capg.lenskart.service;

import java.util.List;

import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.Order;

public interface CustomerServices {
	public List<Glass> viewAllGlass();
	public Glass viewGlassById(int glassId);
	public double lensPower(double power);
	
	public Cart addToCart(int glassId,int userId);
	public Cart viewCart(int userId);
	public Cart removeFromCart(int glassId,int userId);
	public double cartAmount(int userId);
	
	
	public List<Order> viewAllOrder(int userId);
	public Long placeOrder(int userId);
	public int cancelOrder(long orderId,int userId);

	public List<String> viewPaymentMode();
	public int pay(long orderId,String paymentKey);
	
	public List<Glass> sortProductByPrice();
	public List<Glass> viewProductByType(String type);
}
