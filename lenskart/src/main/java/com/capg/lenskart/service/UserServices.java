package com.capg.lenskart.service;

import com.capg.lenskart.model.User;

public interface UserServices {
	public User getLogin(String userName, String userPassword);
	public User registerUser(User user);
	public User passwordReset(String emailId);
	public String forgotPassword(String userName, String secretAnswer);

	

}
