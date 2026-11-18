package com.capg.lenskart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "User_Table")
//@IdClass(UserId.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String secretAnswer;

	
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Username should contain alphabets only!")
	@NotEmpty(message = "Password can't be empty!")
	private String userName;
	
	@NotEmpty(message = "Password can't be empty!")
	@Size(min = 8, max = 20, message = "Password has to be of minimum 8 chars!")
	private String userPassword;
	
	private String userType;
	@OneToOne
	@JoinColumn(name="fk_pId")
	private PersonalDetails details;
	
	@OneToOne
	@JoinColumn(name="fk_cartId")
	private Cart cart;
	
	@OneToMany
//	(mappedBy= "user")
	List<Order> order;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public PersonalDetails getDetails() {
		return details;
	}
	public void setDetails(PersonalDetails details) {
		this.details = details;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
