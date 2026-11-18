package com.capg.lenskart.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.Order;
import com.capg.lenskart.model.Payment;
import com.capg.lenskart.model.User;
import com.capg.lenskart.repository.CardRepository;
import com.capg.lenskart.repository.CartRepository;
import com.capg.lenskart.repository.CustomerRepository;
import com.capg.lenskart.repository.GlassRepository;
import com.capg.lenskart.repository.OrderRepository;
import com.capg.lenskart.repository.PaymentRepository;
import com.capg.lenskart.repository.UserRepository;
import com.capg.lenskart.service.CustomerServices;

@Service
public class CustomerServiceImpl implements CustomerServices{

	@Autowired
	private GlassRepository glassRepository;
	@Autowired
	private CustomerRepository custRepository;
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Glass> viewAllGlass() {
		List<Glass> listOfProduct = glassRepository.findAll();

		return listOfProduct;
	}

	@Override
	public Glass viewGlassById(int glassId) {
		Glass g=glassRepository.findById(glassId).get();
		return g;
	}

	@Override
	public Cart addToCart(int glassId,int userId) {	
		Cart c=custRepository.getCartId(userId);
		Glass g=glassRepository.findById(glassId).get();
		List<Glass> gList=cartRepository.glassList(c.getCartId());
	
		gList.add(g);
		c.setGlassList(gList);
		//dont use double Use Double
		Double amount=0.0;
		for(Glass gl:gList) {
			amount=amount+gl.getPrice()+gl.getLens().getAdditionalPrice();
		}
		
		c.setCartAmount(amount);
		
		Cart cNew=c;
		cartRepository.save(c);
		return cNew;
	}
	
	@Override
	public Cart viewCart(int userId) {
		Cart c=custRepository.getCartId(userId);
		return c;
	}

	@Override
	public Cart removeFromCart(int glassId,int userId) {
		Cart c=custRepository.getCartId(userId);
		Glass g=glassRepository.findById(glassId).get();
		List<Glass> gList=cartRepository.glassList(c.getCartId());
		
		gList.remove(g);
		c.setGlassList(gList);
		c.setCartAmount(c.getCartAmount()-g.getPrice()-g.getLens().getAdditionalPrice());
		
		Cart cNew=c;
		cartRepository.save(cNew);
		return cNew;
	}
	
	@Override
	public double cartAmount(int userId) {   ///not Needed now
		Cart c=custRepository.getCartId(userId);
		List<Glass> gList=cartRepository.glassList(c.getCartId());
		Double amount=0.0;
		for(Glass g:gList) {
			amount=amount+g.getPrice()+g.getLens().getAdditionalPrice();
		}
		c.setCartAmount(amount);
		cartRepository.save(c);
		return amount;
	}

	@Override
	public double lensPower(double power) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> viewAllOrder(int userId) {
		
		return userRepository.getById(userId).getOrder();
	}

	@Override
	public Long placeOrder(int userId) {
		Order ord=new Order();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateFormat.format(date);
		
		ord.setOrderDate(date);
		
//		ord.setCart(custRepository.getCartId(userId));
		
//		ord.setUser(custRepository.findById(userId).get());
		
		ord.setOrderId(new Date().getTime());///unique id generate
		
		ord.setOrderStatus("Pending");
		
		
		
		
		
		Cart c=custRepository.getCartId(userId);
		List<Glass> gList=c.getGlassList();
		ord.setGlassList(gList);
		ord.setOrderAmount(c.getCartAmount());
		
		
		c.setCartAmount(0.0);
		
		
		
		orderRepository.save(ord);
		c.getGlassList().removeAll(gList);
		cartRepository.save(c);
		
		User u=userRepository.findById(userId).get();
		u.getOrder().add(ord);
		userRepository.save(u);
		
	
	
		
		return ord.getOrderId();
	}

	@Override
	public int cancelOrder(long orderId,int userId) {
		Order ord=orderRepository.findById(orderId).get();
		ord.setOrderStatus("cancelled");
		orderRepository.save(ord);
		return 0;
	}

	@Override
	public List<String> viewPaymentMode() {
		List<String> paymentMethods=new ArrayList<>();
		paymentMethods.add("Upi");
		paymentMethods.add("Card payment");
		return paymentMethods;
	}

	@Override
	public int pay(long orderId, String uniqueKey) {
		Order ord=orderRepository.findById(orderId).get();
		Payment pay=new Payment();
		pay.setTransactionId(orderId);
		pay.setPaymentAmount(ord.getOrderAmount());
		pay.setPaymentMode("Card Payment");
		try {
			String trueKey=cardRepository.findById(uniqueKey).get().getUniqueKey();
			ord.setOrderStatus("Payment Successful");
			pay.setPaymentStatus("success");
			paymentRepository.save(pay);
			orderRepository.save(ord);
			return 1;
		}
		catch(NoSuchElementException e) {
			ord.setOrderStatus("Payment Failed");
			pay.setPaymentStatus("failed");
			paymentRepository.save(pay);
			orderRepository.save(ord);
			return 0;
		}
		
//		if(uniqueKey.matches(trueKey)) {
//			
//			ord.setOrderStatus("Payment Successful");
//			orderRepository.save(ord);
//			return 1;
//		}
//		else {
//			ord.setOrderStatus("Payment Failed");
//			orderRepository.save(ord);
//			return 0;
//		}
		
		
		
	}
	@Override
	public List<Glass> sortProductByPrice() {
		return glassRepository.sortProductByPrice();
	}

	@Override
	public List<Glass> viewProductByType(String type) {
		return glassRepository.viewProductByType(type); 
		
	}

	

	

}
