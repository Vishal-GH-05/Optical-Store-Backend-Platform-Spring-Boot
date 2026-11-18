package com.capg.lenskart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.lenskart.exception.EmtyCartException;
import com.capg.lenskart.exception.NoGlassFoundException;
import com.capg.lenskart.exception.NoSuchUserFoundException;
import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.User;
import com.capg.lenskart.repository.AdminRepository;
import com.capg.lenskart.repository.GlassRepository;
import com.capg.lenskart.service.AdminServices;

@RestController
@RequestMapping("api/admin")
public class AdminController {

@Autowired 
private AdminServices service;

@Autowired
private AdminRepository adminRepository;

@Autowired
private GlassRepository glassRepository;


@GetMapping(path="customer/{userId}")
public User viewCustomerById(@PathVariable int userId) {
	if(adminRepository.existsById(userId)) {
		return service.viewCustomerById(userId);
	}else {
		throw new NoSuchUserFoundException();
	}
}

@GetMapping(path="customer/viewAll")
public List<User> viewAllCustomers() {
	return service.viewAllCustomers();
}


@GetMapping(path="glass/viewAll")
public List<Glass> viewAllGlass() {
	return service.viewAllGlass();
}


@GetMapping(path="glass/{glassId}")
public Glass viewGlassById(@PathVariable int glassId) {
	if(glassRepository.existsById(glassId)) {
		return service.viewGlassById(glassId);
	}else {
		throw new NoGlassFoundException();
	}
}
@PostMapping(path="glass/add")
public Glass addGlass(@RequestBody Glass glass)
{
	return service.addGlass(glass);
}


//@DeleteMapping(path="deleteGlass/{glassId}")
//public void deleteGlass(@RequestParam int glassId) {
//	
//	if(glassRepository.existsById(glassId)) {
//		glassRepository.deleteById(glassId);
////		return service.deleteGlass(glassId);	
//	}else {
//		throw new EmtyCartException();
//	}
//}	
}

