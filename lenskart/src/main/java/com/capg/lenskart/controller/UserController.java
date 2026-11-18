package com.capg.lenskart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.lenskart.exception.EmtyInputFieldException;
import com.capg.lenskart.exception.NoSuchUserFoundException;
import com.capg.lenskart.model.User;
import com.capg.lenskart.service.UserServices;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserServices service;
		@GetMapping(path="user/login/{userName}/{userPassword}")
	   public User getLogin(@PathVariable String userName,@PathVariable String userPassword)
	   {
		   
		if(userName.equals(null) || userPassword.equals(null)) {
			throw new EmtyInputFieldException();
		}
		
		   User user = service.getLogin( userName, userPassword);
		   if(user == null) {
			   throw new NoSuchUserFoundException("No such user found!");
		   }else {
			   return user; 
		   }
		  
	   }
		@PostMapping(path="user/register")
		public User registerUser(@RequestBody User user)
		{
			return service.registerUser(user);
		}
		
		
		@GetMapping(path="user/forgotPassword/{userName}/{secretAnswer}")
		   public String forgotPassword(@PathVariable String userName, @PathVariable String secretAnswer)
		   {
			   
			   return service.forgotPassword( userName, secretAnswer);
		   }

		

}
