package com.capg.lenskart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.lenskart.model.Cart;
import com.capg.lenskart.model.User;
import com.capg.lenskart.service.UserServices;
import com.capg.lenskart.repository.UserRepository;
@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User getLogin(String userName, String userPassword) {
		
		User user =repository.getLogin(userName, userPassword);
//		Cart c=new Cart();
        return user;
	}

	@Override
	public User registerUser(User userObj) {
		User user=repository.saveAndFlush(userObj);
		return user;
	}

	@Override
	public User passwordReset(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String forgotPassword(String userName, String secretAnswer) {
		// TODO Auto-generated method stub
		int userId =repository.getUserId(userName, secretAnswer);
		@SuppressWarnings("deprecation")
		User user = repository.getById(userId);
		if(user.getSecretAnswer().equals(secretAnswer)) {
			return user.getUserPassword();
		}
		return "Invalid Answer";
	}


}
