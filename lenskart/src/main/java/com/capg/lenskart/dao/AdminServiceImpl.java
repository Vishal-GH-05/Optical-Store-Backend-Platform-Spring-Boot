package com.capg.lenskart.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.capg.lenskart.model.Customer;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.User;
import com.capg.lenskart.repository.AdminRepository;
import com.capg.lenskart.repository.CustomerRepository;
import com.capg.lenskart.repository.GlassRepository;
import com.capg.lenskart.repository.UserRepository;
import com.capg.lenskart.service.AdminServices;

@Service
public class AdminServiceImpl implements AdminServices{

	@Autowired
	private GlassRepository glassRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private AdminRepository adminRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<Glass> viewAllGlass() {
		List<Glass> listOfProduct = glassRepository.findAll();
		return listOfProduct;
	}

	@Override
	public Glass viewGlassById(int glassId) {
		Glass g= glassRepository.findById(glassId).get();
		return g;
	}

	@Override
	public List<User> viewAllCustomers() {
//		String custName = adminRepository.viewAllCustomer("customer");
//		List<User> listOfCustomer = new ArrayList<>();
//		listOfCustomer.add(userRepository.getCustomer(custName));
//		List listOfCustomer = repo.findAll();
		List<User> listOfCustomer = adminRepository.findAllCustomer("customer");
		return listOfCustomer;
	}

	@Override
	public User viewCustomerById(int userId) {
		User u= customerRepository.findById(userId).get();
		return u;
	}

	@Override
	public Glass addGlass(Glass glassObj) {
		// TODO Auto-generated method stub
		Glass glass1=glassRepository.saveAndFlush(glassObj);
		return glass1;
	}

//	@Override
//	public void deleteGlass(int glassId) {
//		// TODO Auto-generated method stub
//		glassRepository.deleteById(glassId);
//	}

}
