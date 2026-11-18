package com.capg.lenskart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.lenskart.exception.EmtyCartException;
import com.capg.lenskart.exception.GlassAlreadyExistsInCartException;
import com.capg.lenskart.exception.NoGlassFoundException;
import com.capg.lenskart.exception.NoSuchUserFoundException;
import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.Order;
import com.capg.lenskart.repository.CustomerRepository;
import com.capg.lenskart.repository.GlassRepository;
import com.capg.lenskart.service.CustomerServices;



@RestController
@CrossOrigin("*")
//@RequestMapping("api/customer")
public class CustomerController {
	@Autowired
	private CustomerServices service;
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private GlassRepository glassRepository;
	
	@GetMapping(path = "glass/viewAll")
	public List<Glass> viewAllGlass() {
		return service.viewAllGlass();
	}

	@GetMapping(path = "glass/{glassId}")
	public Glass viewGlassById(@PathVariable int glassId) {

		return service.viewGlassById(glassId);
	}

	@GetMapping(path = "addToCart/{userId}/{glassId}")
	public Cart addToCart(@PathVariable int userId, @PathVariable int glassId) {
		try {
			Cart cart = service.addToCart(glassId, userId);
			return cart;
		} catch (Exception e) {
			throw new GlassAlreadyExistsInCartException("Item is already in cart");
		}

	}

	@GetMapping(path = "view-cart/{userId}")
	public Cart viewCart(@PathVariable int userId) {
//		service.cartAmount(userId);
		return service.viewCart(userId);
	}

	@DeleteMapping(path = "removeFromCart/{userId}")
	public Cart removeFromCart(@PathVariable int userId, @RequestParam int glassId) {

		return service.removeFromCart(glassId, userId);
	}

	@GetMapping(path = "view-order/{userId}")
	public List<Order> viewOrder(@PathVariable int userId) {
//		service.cartAmount(userId);
		return service.viewAllOrder(userId);
	}

	@GetMapping(path = "placeOrder/{userId}")
	public Long placeOrder(@PathVariable int userId) {

		return service.placeOrder(userId);
	}

	@PutMapping(path = "cancelOrder/{userId}")
	public int cancelOrder(@PathVariable int userId, @RequestParam long orderId) {

		return service.cancelOrder(orderId, userId);
	}

	@GetMapping(path = "pay/{orderId}")
	public int pay(@PathVariable long orderId, @RequestParam String uniqueKey) {

		return service.pay(orderId, uniqueKey);
	}

	@GetMapping(path = "glass/sortByPrice")
	public List<Glass> sortProductByPrice() {

		return service.sortProductByPrice();
	}

	@GetMapping(path = "glass/viewByType/{type}")
	public List<Glass> viewProductByType(@PathVariable String type) {
		return service.viewProductByType(type);

	}
}
