package com.capg.lenskart.service;

import java.util.List;

//import com.capg.lenskart.model.Customer;
import com.capg.lenskart.model.Glass;
import com.capg.lenskart.model.User;

public interface AdminServices {
	public List<Glass> viewAllGlass();
	public Glass viewGlassById(int glassId);
	public List<User> viewAllCustomers();
	public User viewCustomerById(int userId);
	public Glass addGlass(Glass glass);
//	public void deleteGlass(int glassId);
	
}
